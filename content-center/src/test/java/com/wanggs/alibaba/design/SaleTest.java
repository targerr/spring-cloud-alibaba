package com.wanggs.alibaba.design;

import com.wanggs.alibaba.design.sale.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 *
 * 如果项目当中出现大量的if else,我们可以考虑是否可以抽象这个对象，以及他的行为，把它设计成策略模式
 * 或者是说，一个对象的行为经常发生变化，扩展性比较高也要考虑一下策略模式是否合适
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleTest {
    @Autowired
    private SaleService saleService;
    @Autowired
    private CalculateActivity calculateActivity;


    @Test
    public void discount() {
        double vip = saleService.sale("vip", 100);

        System.out.println("折扣： " + vip);
    }

    @Test
    public void V2() {
        double vip = saleService.saleV2("vip", 100);

        System.out.println("折扣： " + vip);

        System.out.println(saleService.saleV2("normal", 100));
    }

    @Test
    public void V3() {
        double discount = 0;
        String userType = "vip";
        if ("noraml".equals(userType)) {
            discount = calculateActivity.executeCalculateStrategy(new NormalStrategy(), 100);

        }
        if ("vip".equals(userType)) {
            discount = calculateActivity.executeCalculateStrategy(new VipStrategy(), 100);
        }


        System.out.println("折扣： " + discount);
    }

    /**
     * 演进
     */
    @Test
    public void V4() {
        // 优化掉if else
        String userType = "vip";
        double discount = calculateActivity.executeCalculateStrategy(CalculateStrategyFactory.getCalculateStrategy(userType), 100L);
        System.out.println("折扣： " + discount);
    }
}
