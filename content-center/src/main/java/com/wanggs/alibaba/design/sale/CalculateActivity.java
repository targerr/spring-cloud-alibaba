package com.wanggs.alibaba.design.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 * 包装一下策略
 */
@Component
public class CalculateActivity {

    public double executeCalculateStrategy(CalculateStrategy calculateStrategy, double free) {
        return calculateStrategy.discount(free);

    }
}
