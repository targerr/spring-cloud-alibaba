package com.wanggs.alibaba.design.sale;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: wgs
 * @Date: 2021/4/4
 */
public class CalculateStrategyFactory {
    private static Map<String, CalculateStrategy> CALCULATE_STRATEGY_MAP = new ConcurrentHashMap<>();

    static {
        CALCULATE_STRATEGY_MAP.put(CalculateKey.NORMAL,new NormalStrategy());
        CALCULATE_STRATEGY_MAP.put(CalculateKey.VIP,new VipStrategy());
    }

    /**
     * 禁止外部创建
     */
    private CalculateStrategyFactory(){};

    public static CalculateStrategy getCalculateStrategy(String usrType) {
        CalculateStrategy calculateStrategy = CALCULATE_STRATEGY_MAP.get(usrType);
        return calculateStrategy == null ? new VipStrategy() : calculateStrategy;
    }
}

 interface CalculateKey{
   final String NORMAL = "normal";
   final String VIP = "vip";
}
