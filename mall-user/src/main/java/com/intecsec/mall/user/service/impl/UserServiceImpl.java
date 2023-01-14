package com.intecsec.mall.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.common.exception.BaseException;
import com.intecsec.mall.common.utils.DOUtils;
import com.intecsec.mall.common.utils.JwtUtil;
import com.intecsec.mall.user.dto.UserDTO;
import com.intecsec.mall.user.dto.UserLoginDTO;
import com.intecsec.mall.user.dto.UserLoginResultDTO;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.entity.UserConsignee;
import com.intecsec.mall.user.enums.RoleEnum;
import com.intecsec.mall.user.enums.UserResponseEnum;
import com.intecsec.mall.user.service.UserService;
import com.intecsec.mall.user.mapper.UserConsigneeMapper;
import com.intecsec.mall.user.mapper.UserMapper;
import com.intecsec.mall.redis.RedisManager;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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

    @Resource
    private RedisManager redisManager;

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
    public int add(UserLoginDTO userLoginDTO)  throws BaseException {
        User user = getUserByUserName(userLoginDTO);
        if (user != null) {
            throw new BaseException(UserResponseEnum.USER_EXISTS);
        }

        String salt = BCrypt.gensalt();
        String password = BCrypt.hashpw(userLoginDTO.getPassword(), salt);
        User newUser = new User();
        newUser.setUserName(userLoginDTO.getUserName());
        newUser.setPassword(password);
        newUser.setSalt(salt);
        boolean isValidRole = userLoginDTO.getRole() != null && RoleEnum.roleOf(userLoginDTO.getRole());
        newUser.setRole(isValidRole ? userLoginDTO.getRole() : RoleEnum.COMMON.getRole());
        return userMapper.insert(newUser);
    }

    private User getUserByUserName(UserLoginDTO userLoginDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", userLoginDTO.getUserName());
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public UserLoginResultDTO login(UserLoginDTO userLoginDTO) {
        UserLoginResultDTO userLoginResultDTO;

        User user = getUserByUserName(userLoginDTO);
        if (user == null) {
            throw new BaseException(UserResponseEnum.USER_NOT_EXISTS);
        }

        boolean isValidPassword = BCrypt.checkpw(userLoginDTO.getPassword(), user.getPassword());
        log.info("isValidPassword:{}", isValidPassword);
        if(isValidPassword) {
            userLoginResultDTO = DOUtils.copy(user, UserLoginResultDTO.class);
            String accessToken = UUID.randomUUID().toString().replace("-", "");
            String token = JwtUtil.createJWT(accessToken, user.getUserName(), 3600 * 1000L);

            log.info("cache accessToken:{}, userId:{}", accessToken, user.getId());
            redisManager.set(accessToken, user.getId());

            userLoginResultDTO.setToken(token);
        } else {
            throw new BaseException(UserResponseEnum.PASSWORD_INVALID);
        }

        return userLoginResultDTO;
    }

    @Override
    public UserLoginResultDTO getUserByToken(String token) {
        Claims claims = JwtUtil.parseJWT(token);
        log.info("claims:{}", claims);

        String accessToken = claims.getId();
        if(StringUtils.isNotEmpty(accessToken)) {
            Long userId = redisManager.getLong(accessToken);
            log.info("get from cache, from accessToken:{}, to userId:{}, ", userId, accessToken);
            if(Objects.nonNull(userId)) {
                UserDTO userDTO = getUser(userId);

                UserLoginResultDTO userLoginResultDTO = new UserLoginResultDTO();
                userLoginResultDTO.setToken(token);
                userLoginResultDTO.setUserName(userDTO.getUserName());
                userLoginResultDTO.setAvatar(userDTO.getAvatar());
                userLoginResultDTO.setNickName(userDTO.getNickName());
                userLoginResultDTO.setRole(userDTO.getRole());
                return userLoginResultDTO;
            }
        }

        throw new BaseException(UserResponseEnum.LOGIN_TOKEN_INVALID);
    }


    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(Long userId, UserDTO userDTO) {

        User user = DOUtils.copy(userDTO, User.class);
        user.setId(userId);
        user.setGmtUpdated(new Date());

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
