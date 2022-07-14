package com.intecsec.mall.user.manager.impl;

import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.manager.UserManager;
import com.intecsec.mall.user.mapper.UserConsigneeMapper;
import com.intecsec.mall.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
@Repository
@Slf4j
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserConsigneeMapper userConsigneeMapper;

    @Override
    public UserDTO getUser(Long userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return DOUtils.copy(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<User> userList = userMapper.getList(offset, pageSize);
        return DOUtils.copyList(userList, UserDTO.class);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(Long userId, UserDTO userDTO) {

        User user = DOUtils.copy(userDTO, User.class);
        user.setId(userId);
        user.setGmtUpdate(new Date());

        UserConsignee userConsignee = new UserConsignee();
        userConsignee.setUserId(userId);
        userConsignee.setMobile("15876505396");
        int updateResult = userConsigneeMapper.updateByPrimaryKeySelective(userConsignee);
        log.info("updateResult:{}", updateResult);

        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int delete(Long userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }
}
