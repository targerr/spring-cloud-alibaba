package com.wanggs.alibaba.configuration;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.DynamicServerListLoadBalancer;
import com.netflix.loadbalancer.Server;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.NacosDiscoveryProperties;
import org.springframework.cloud.alibaba.nacos.ribbon.NacosServer;

/**
 * @Author: wgs
 * @Date: 2021/2/14
 * 参考： http://www.imooc.com/article/288660
 */
@Slf4j
public class NacosWeightRandomV2Rule extends AbstractLoadBalancerRule {
    @Autowired
    private NacosDiscoveryProperties discoveryProperties;

    @Override
    public Server choose(Object key) {
        DynamicServerListLoadBalancer loadBalancer = (DynamicServerListLoadBalancer) getLoadBalancer();
        // 请求微服务的名称
        String name = loadBalancer.getName();
        try {
            // 拿到微服务发现的相关API; nacos client 自动通过基于负载均衡的算法,给我们选择一个实例
            Instance instance = discoveryProperties.namingServiceInstance()
                    .selectOneHealthyInstance(name);

            log.info("选中的instance = {}, port={}", instance,instance.getPort());

            /*
             * instance转server的逻辑参考自：
             * org.springframework.cloud.alibaba.nacos.ribbon.NacosServerList.instancesToServerList
             */
            return new NacosServer(instance);
        } catch (NacosException e) {
            log.error("发生异常", e);
            return null;
        }
    }


    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        // 读取配置文件,并初始化NacosWeightRule
    }
}
