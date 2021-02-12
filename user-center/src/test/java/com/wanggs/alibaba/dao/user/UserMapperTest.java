package com.wanggs.alibaba.dao.user;


import com.alibaba.fastjson.JSON;
import com.wanggs.alibaba.domain.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wgs
 * @Date: 2021/2/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void findAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(e -> System.out.println(JSON.toJSONString(e,true)));

    }
}
