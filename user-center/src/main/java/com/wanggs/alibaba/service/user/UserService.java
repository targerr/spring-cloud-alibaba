package com.wanggs.alibaba.service.user;

import com.wanggs.alibaba.dao.user.UserMapper;
import com.wanggs.alibaba.domain.entity.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wgs
 * @Date: 2021/2/12
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {
    private final UserMapper userMapper;

    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }
}
