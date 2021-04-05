package com.wanggs.alibaba.design.sale;

import org.springframework.stereotype.Service;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 * 普通会员
 */
@Service
public class NormalStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "normal";
    }

    @Override
    public double discount(double free) {
        return free * 1.0;
    }
}
