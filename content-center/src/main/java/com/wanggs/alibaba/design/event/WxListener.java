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
public class WxListener implements ApplicationListener<OrderEvent> {
    @Override
    public void onApplicationEvent(OrderEvent event) {
        // 省略多行微信推送内容

        log.error("【订单】 发送微信通知！");
    }
}
