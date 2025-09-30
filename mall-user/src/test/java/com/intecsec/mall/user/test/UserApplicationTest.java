package com.intecsec.mall.user.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.intecsec.mall.user.entity.User;
import com.intecsec.mall.user.mapper.UserMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;
import java.util.*;

/**
 * @description:
 * @author: peter.peng
 * @create: 2022-11-16 21:08
 **/
@SpringBootTest
public class UserApplicationTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testJJWT() {
        long currentTimeMillis = System.currentTimeMillis();
        currentTimeMillis += 1000000L;
        Date date = new Date(currentTimeMillis);
        String secret = "it's a secret";
        JwtBuilder jwtBuilder = Jwts.builder().setId("123")
                .setSubject("peter")
                .setIssuedAt(new Date())
                .setExpiration(date)
                .claim("roles", "admin")
                .signWith(SignatureAlgorithm.HS256, secret);
        String compact = jwtBuilder.compact();
        System.out.println(compact);

        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(compact).getBody();
        System.out.println(claims);
    }

    @Test
    public void testWrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // queryWrapper.ge("age", 20);

        // eq ne
        // queryWrapper.eq("user_name", "qq");

        // queryWrapper.between("age", 20, 30);

        // like
        queryWrapper.like("user_name", "6");

        queryWrapper.orderByDesc("age");

        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);
    }

    @Test
    public void testDelete() {
        int i = userMapper.deleteById(1L);
        System.out.println(i);

        int i1 = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(i1);

        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name", "qq55");
        int i2 = userMapper.deleteByMap(columnMap);
        System.out.println(i2);
    }

    @Test
    public void testPage() {
        Page<User> page = new Page(2, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        long pages = userPage.getPages();
        long current = userPage.getCurrent();
        List<User> records = userPage.getRecords();
        long total = userPage.getTotal();
        boolean hasNext = userPage.hasNext();
        boolean hasPrevious = userPage.hasPrevious();
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }


    @Test
    public void testSelectMap() {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name", "peter");
        columnMap.put("password", "123456");
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }

    @Test
    public void testSelectIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println(users);
    }

    @Test
    public void testOptimisticLocker() {
        User user = userMapper.selectById(3L);
        System.out.println(user);

        user.setUserName("qq3");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3L);
        user.setUserName("qq66");
        user.setNickName("weixin2");
        int count = userMapper.updateById(user);
        System.out.println(count);
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUserName("qq6");
        user.setNickName("weixin");
        user.setAvatar("2.jpg");
        user.setPassword("678910");
        // user.setVersion(1);
        //user.setGmtCreated(new Date());
        //user.setGmtUpdate(new Date());
        // user.setDeleteMark(0);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}
