package com.wanggs.alibaba.design.service;

import com.wanggs.alibaba.design.event.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 订单操作，业务伪代码-->发送短信
 * @Author: wgs
 * @Date: 2021/4/3
 */
@Service
@Slf4j
public class OrderService {
    @Autowired
    private ApplicationContext applicationContext;
    public void saveOrder(){
        // TODO 订单业务复杂，省略前面500行逻辑代码--放入数据库

        //1. 订单入库
        log.error("【订单入库】 订单保存了");

        // 创建容器
        OrderEvent orderEvent = new OrderEvent("创建订单");
        // 发布事件
        applicationContext.publishEvent(orderEvent);
        //2. 发送短信
      //  log.error("【订单入库】 发送短信");
    }
}
