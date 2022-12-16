package com.intecsec.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.utils.BCrypt;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.dto.UserLoginDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.enums.RoleEnum;
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
    public int add(UserDTO userDTO) {
        User user = getUserByUserName(userDTO);
        if (user != null) {
            return 0;
        }

        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(userDTO.getPassword(), salt);
        User newUser = new User();
        newUser.setUserName(userDTO.getUserName());
        newUser.setPassword(password);
        newUser.setSalt(salt);
        boolean isValidRole = userDTO.getRole() != null && RoleEnum.roleOf(userDTO.getRole());
        newUser.setRole(isValidRole ? userDTO.getRole() : RoleEnum.COMMON.getRole());
        return userMapper.insert(newUser);
    }

    private User getUserByUserName(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userDTO.getUserName());
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public UserLoginDTO login(UserDTO userDTO) {
        UserLoginDTO userLoginDTO = new UserLoginDTO();

        User user = getUserByUserName(userDTO);
        if (user == null) {
            return userLoginDTO;
        }

        String salt = user.getSalt();
        boolean isValidPassword = BCrypt.checkpw(userDTO.getPassword(), salt);
        log.info("isValidPassword:{}", isValidPassword);
        if(isValidPassword) {
            userLoginDTO = DOUtils.copy(user, UserLoginDTO.class);
            userLoginDTO.setAccessToken(BCrypt.gensalt());
        }

        return userLoginDTO;
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
