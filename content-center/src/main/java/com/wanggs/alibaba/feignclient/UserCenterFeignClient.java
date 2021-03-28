package com.wanggs.alibaba.feignclient;

import com.wanggs.alibaba.configuration.UserCenterFeignConfiguration;
import com.wanggs.alibaba.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: wgs
 * @Date: 2021/3/28
 */
//@FeignClient(name = "user-center",configuration = UserCenterFeignConfiguration.class)
@FeignClient(name = "user-center")
public interface UserCenterFeignClient {
    /**
     * http://user-center/users/{id}
     * @param id
     * @return
     */
    @GetMapping("/users/{id}")
    public UserDTO findById(@PathVariable Integer id);
}
