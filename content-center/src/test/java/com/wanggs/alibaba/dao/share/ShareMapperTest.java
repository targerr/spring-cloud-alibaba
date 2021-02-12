package com.wanggs.alibaba.dao.share;

import com.alibaba.fastjson.JSON;
import com.wanggs.alibaba.domain.entity.share.Share;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareMapperTest {

    @Autowired
    private ShareMapper shareMapper;

    @Test
    public void findAll() {
        List<Share> shares = shareMapper.selectAll();
        shares.forEach(e -> System.out.println(JSON.toJSONString(e, true)));
    }
}