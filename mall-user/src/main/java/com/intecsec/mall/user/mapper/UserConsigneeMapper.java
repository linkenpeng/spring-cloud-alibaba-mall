package com.intecsec.mall.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.intecsec.mall.user.entity.UserConsignee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserConsigneeMapper  extends BaseMapper<UserConsignee> {

    /**
    int deleteByPrimaryKey(Long id);

    int insert(UserConsignee record);

    int insertSelective(UserConsignee record);

    UserConsignee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserConsignee record);

    int updateByPrimaryKey(UserConsignee record);
     */
}