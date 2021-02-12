package com.wanggs.alibaba.service.share;

import com.wanggs.alibaba.dao.share.ShareMapper;
import com.wanggs.alibaba.domain.dto.content.ShareDTO;
import com.wanggs.alibaba.domain.dto.user.UserDTO;
import com.wanggs.alibaba.domain.entity.share.Share;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShareService {
    private final ShareMapper shareMapper;
    private final RestTemplate restTemplate;

    public ShareDTO findById(Integer id) {
        // 获取分享详情
        Share share = this.shareMapper.selectByPrimaryKey(id);
        // 发布人Id
        Integer userId = share.getUserId();
        // 获取发布人姓名
        UserDTO userDTO = restTemplate.
                getForObject("http://127.0.0.1:8080/users/{id}",
                UserDTO.class, userId);

        // 装配ShareDTO对象
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickname(userDTO.getWxNickname());
        return shareDTO;
    }

}
