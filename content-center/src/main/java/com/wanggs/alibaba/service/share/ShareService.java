package com.wanggs.alibaba.service.share;

import com.wanggs.alibaba.dao.share.ShareMapper;
import com.wanggs.alibaba.domain.dto.content.ShareDTO;
import com.wanggs.alibaba.domain.dto.user.UserDTO;
import com.wanggs.alibaba.domain.entity.share.Share;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class ShareService {
    private final ShareMapper shareMapper;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人Id
        Integer userId = share.getUserId();

        // 获取发布人姓名
        // 第一版
//        UserDTO userDTO = restTemplate.
//                getForObject("http://127.0.0.1:8080/users/{id}",
//                        UserDTO.class, userId);
//

        // 第二版
        // 获取用户所有实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//        String targetUri = instances.stream()
//               // 数据转换
//               .map(instance -> instance.getUri().toString()+"/users/{id}").findFirst()
//               // 如果实例为空者报错
//                .orElseThrow(() -> new IllegalArgumentException("url不存在!"));
//
//       log.info("【请求地址】 --> {}",targetUri);
//
//        // 获取发布人姓名
//        UserDTO userDTO = restTemplate.getForObject(targetUri, UserDTO.class, userId);

        // 第三版模拟负载均衡
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-center");
//        List<String> targetUris = instances.stream()
//                // 数据转换
//                .map(instance -> instance.getUri().toString()+"/users/{id}").collect(Collectors.toList());
//
//        // 随机获取
//        Integer random = ThreadLocalRandom.current().nextInt(targetUris.size());
//
//        log.info("【请求地址】 --> {}",targetUris.get(random));
//
//        // 获取发布人姓名
//        UserDTO userDTO = restTemplate.getForObject(targetUris.get(random), UserDTO.class, userId);

        // 第四版使用LoadBalance负载均衡
        UserDTO userDTO = restTemplate.getForObject("http://user-center/users/{id}", UserDTO.class,userId);

        // 装配ShareDTO对象
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

}
