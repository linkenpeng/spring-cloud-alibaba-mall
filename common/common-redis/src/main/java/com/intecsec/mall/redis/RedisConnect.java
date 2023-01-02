package com.intecsec.mall.redis;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import reactor.core.publisher.Mono;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-02-12 10:41
 **/
public class RedisConnect {

    public static void main(String[] args) throws Exception {
        RedisClient client = RedisClient.create("redis://localhost");
        StatefulRedisConnection<String, String> connection = client.connect();

        sync(connection);
        async(connection);
        reactive(connection);
    }

    public static void sync(StatefulRedisConnection<String, String> connection) {
        RedisStringCommands sync = connection.sync();
        String value = (String ) sync.get("key");
        System.out.println(value);
    }

    public static void async(StatefulRedisConnection<String, String> connection) throws Exception {
        RedisStringAsyncCommands<String, String> async = connection.async();
        RedisFuture<String> set = async.set("key", "value");
        System.out.println(set.get());
        RedisFuture<String> get = async.get("key");
        System.out.println(get.get());
    }

    public static void reactive(StatefulRedisConnection<String, String> connection) {
        RedisStringReactiveCommands<String, String> reactive = connection.reactive();
        Mono<String> set = reactive.set("key", "value");
        Mono<String> get = reactive.get("key");
        set.subscribe();
        System.out.println(get.block());
    }
}
