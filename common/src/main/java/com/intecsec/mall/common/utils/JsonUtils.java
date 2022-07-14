package com.intecsec.mall.common.utils;

import com.google.gson.*;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 */
public class JsonUtils {

	private static final Gson gson;
	private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss[.SSS]";
	private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);

	static {
		gson = createGson();
	}

	public static Gson createGson() {
		GsonBuilder gb = new GsonBuilder();
		gb.disableHtmlEscaping();
		gb.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
		// gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
		gb.registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(DateFormat.LONG);
		gb.registerTypeAdapter(Date.class, new DateDeserializer()).setDateFormat(DateFormat.LONG);
		return gb.create();
	}

	/**
	 * 将对象转成json字符串
	 */
	public static final String toJson(Object src) {
		return gson.toJson(src);
	}

	/**
	 * json反序列化成指定类型的对象
	 */
	public static final <T> T parseJson(String jsonStr, Class<T> tClass) {
		T obj = gson.fromJson(jsonStr, tClass);
		return obj;
	}

	/**
	 * json反序列化成指定类型的List对象
	 */
	public static final <T> List<T> parseListJson(String jsonStr, Class<T> tClass) {
		List<T> list = gson.fromJson(jsonStr, new ArrayT<T>(tClass).getType());
		return list;
	}

	/**
	 * json反序列化成Map对象，key为String，value为指定类型
	 */
	public static final <T> Map<String, T> parseStringMap(String jsonStr, Class<T> tClass) {
		Map<String, T> map = gson.fromJson(jsonStr, new MapT<String, T>(String.class, tClass).getType());
		return map;
	}

	/**
	 * json反序列化成Map对象，key为Integer，value为指定类型
	 */
	public static final <T> Map<Integer, T> parseIntegerMap(String jsonStr, Class<T> tClass) {
		Map<Integer, T> map = gson.fromJson(jsonStr, new MapT<Integer, T>(Integer.class, tClass).getType());
		return map;
	}

	public static final class DateSerializer implements JsonSerializer<Date> {

		@Override
		public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.getTime());
		}

	}

	public static final class DateDeserializer implements JsonDeserializer<Date> {

		@Override
		public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			JsonPrimitive jsonPrimitiveType = json.getAsJsonPrimitive();
			if (jsonPrimitiveType.isString()) {
				String jsonDataString = jsonPrimitiveType.getAsString();
				// 是一个数字，按照约定进行转换 long
				if (StringUtils.isNumeric(jsonDataString)) {
					return new Date(jsonPrimitiveType.getAsLong());
				}

				// 使用固定日期时间格式转换 string
				try {
					LocalDateTime localDateTime = LocalDateTime.parse(jsonDataString, DATE_TIME_FORMATTER);
					return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
				} catch (Exception e) {
					throw e;
				}
			}

			// 约定的转换模式: long
			return new Date(jsonPrimitiveType.getAsLong());
		}

	}

	private static final class ArrayT<T> {

		private Class<T> clz;

		public ArrayT(Class<T> clz) {
			this.clz = clz;
		}

		public Type getType() {
			return new ParameterizedType() {
				@Override
				public Type[] getActualTypeArguments() {
					return new Type[] { clz };
				}

				@Override
				public Type getRawType() {
					return ArrayList.class;
				}

				@Override
				public Type getOwnerType() {
					return null;
				}
			};
		}

	}

	private static final class MapT<K, V> {

		private Class<K> clzK;
		private Class<V> clzV;

		public MapT(Class<K> clzK, Class<V> clzV) {
			this.clzK = clzK;
			this.clzV = clzV;
		}

		public Type getType() {
			return new ParameterizedType() {
				@Override
				public Type[] getActualTypeArguments() {
					return new Type[] { clzK, clzV };
				}

				@Override
				public Type getRawType() {
					return Map.class;
				}

				@Override
				public Type getOwnerType() {
					return null;
				}
			};
		}

	}

}
