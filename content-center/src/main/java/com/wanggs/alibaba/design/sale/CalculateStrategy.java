package com.wanggs.alibaba.design.sale;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 * 计算策略
 */
public interface CalculateStrategy {

    /**
     * 会员类型 1.普通会员 2.vip
     * @return
     */
    public String userType();

    /**
     * 计算折扣
     * @param free
     * @return
     */
    public double discount(double free);


}
