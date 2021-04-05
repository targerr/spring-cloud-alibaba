package com.wanggs.alibaba.design.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wgs
 * @Date: 2021/4/3
 */
@Component
@Slf4j
public class SmsListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        // 2. 发送短信操作 --- 省略N行代码
      log.error("【订单】 发送短信！");
    }
}
