package com.wanggs.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.wanggs")
//@EnableDiscoveryClient
public class ContentCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentCenterApplication.class, args);
    }


    /**
     * 在Spring 容器中,创建一个对象,类型是RestTemplate,方法名或者ID 是restTemplate
     * 相当于<bean id = "restTemplate" class="xxx.RestTemplate"></bean>
     * @return
     */
    @Bean
    public RestTemplate restTemplate (){
        return new RestTemplate();
    }
}
