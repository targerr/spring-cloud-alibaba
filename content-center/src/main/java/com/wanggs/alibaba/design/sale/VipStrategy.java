package com.wanggs.alibaba.design.sale;

import org.springframework.stereotype.Service;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 */
@Service
public class VipStrategy implements CalculateStrategy {
    @Override
    public String userType() {
        return "vip";
    }

    @Override
    public double discount(double free) {
        return free * 0.8;
    }
}
