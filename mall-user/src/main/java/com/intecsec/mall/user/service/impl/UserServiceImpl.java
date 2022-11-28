package com.intecsec.mall.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.service.UserService;
import com.intecsec.mall.user.mapper.UserConsigneeMapper;
import com.intecsec.mall.user.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: peter.peng
 * @create: 2020-04-04 22:36
 **/
@Repository
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserConsigneeMapper userConsigneeMapper;

    @Override
    public UserDTO getUser(Long userId) {
        User user = userMapper.selectById(userId);
        return DOUtils.copy(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> getUserList(int page, int pageSize) {
        Page<User> userPage = new Page<>(page, pageSize);
        Page<User> userPageResult = userMapper.selectPage(userPage, null);
        List<User> records = userPageResult.getRecords();
        return DOUtils.copyList(records, UserDTO.class);
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
        int updateResult = userConsigneeMapper.updateById(userConsignee);
        log.info("updateResult:{}", updateResult);

        return userMapper.updateById(user);
    }

    @Override
    public int delete(Long userId) {
        return userMapper.deleteById(userId);
    }
}
