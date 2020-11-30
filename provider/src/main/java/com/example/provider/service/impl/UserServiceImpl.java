package com.example.provider.service.impl;

import com.example.provider.mapper.UserMapper;
import com.example.provider.model.Permission;
import com.example.provider.model.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName UserServiecImpl
 * @Description:
 * @date 2020/11/513:55
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUserName(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public List<Permission> findPermissionsByUserId(Integer userId) {
        return userMapper.findPermissionsByUserId(userId);
    }
}
