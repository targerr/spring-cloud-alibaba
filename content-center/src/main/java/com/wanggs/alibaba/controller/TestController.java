package com.wanggs.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 测试:服务发现,证明内容中心总能找到用户中心
     *
     * @return 用户中心所有实例的地址信息
     */
    @GetMapping("/instanse")
    public List<ServiceInstance> getInstanse() {
        // 查询指定所有实例信息
        // consul  nacos zookeeper eureka
        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
        return instances;
    }
}
