package com.wanggs.alibaba.design.sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: wgs
 * @Date: 2021/4/3
 * 电商业务 --会员 --1.普通会员 2.VIP会员 3.ssvip 根据类型不同设计不同的折扣
 */
@Service
public class SaleService {

    @Autowired
    private NormalStrategy normalStrategy;
    @Autowired
    private VipStrategy vipStrategy;

    Map<String, CalculateStrategy> calculateStrategyMap = new HashMap<>();

    // 构造器注入 --- 交给spring容器
    public SaleService(List<CalculateStrategy> calculateStrategyList) {

        for (CalculateStrategy calculateStrategy : calculateStrategyList) {
            calculateStrategyMap.put(calculateStrategy.userType(), calculateStrategy);
        }
    }

    public double sale(String userType, double fee) {


        // 单一原则 --不违背（这个服务类全是结算折扣的）
        // 开闭原则 --违背了 增加一个会员类型修改需要最近if判断
        if ("noraml".equals(userType)) {
            double discount = normalStrategy.discount(fee);
            return discount;
//            return fee * 1.0;
        }
        if ("vip".equals(userType)) {
            return vipStrategy.discount(fee);
//            return  fee*0.8;
        }

        return fee;
    }

    /*==============去掉 if else ？============*/
    // 放入hashMap中？ 通过spring构造器
    // 总结： HashMap --getString --不确定个数的东西可以利用hashMap代替if else

    /**
     * V2 版本
     * @param userType
     * @param fee
     * @return
     */
    public double saleV2(String userType, double fee) {

        CalculateStrategy calculateStrategy = calculateStrategyMap.get(userType);
        return calculateStrategy.discount(fee);
    }
}
