package com.wanggs.alibaba.design.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Author: wgs
 * @Date: 2021/4/3
 */
public class OrderEvent extends ApplicationEvent {

    public OrderEvent(Object source) {
        super(source);
    }
}
