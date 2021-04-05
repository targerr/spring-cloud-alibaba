package com.wanggs.alibaba.design.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: wgs
 * @Date: 2021/4/3
 */
@Component
@Slf4j
public class TsSortListener  implements SmartApplicationListener{
    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == OrderEvent.class;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {

        log.error("【订单】 信鸽推送！");
    }

    /**
     * 控制順序 ===》数组越大越靠后
     * @return
     */
    @Override
    public int getOrder() {
        return 1000;
    }
}
