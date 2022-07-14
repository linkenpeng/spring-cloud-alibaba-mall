package com.intecsec.mall.user.mapper;

import com.intecsec.mall.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    List<User> getList(@Param("offset") Integer offset, @Param("count") Integer count);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}