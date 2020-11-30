package com.example.provider.service;

import com.example.provider.model.Permission;
import com.example.provider.model.User;

import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName UserService
 * @Description:
 * @date 2020/11/513:54
 */
public interface UserService {
    User findUserByUserName(String username);
    List<Permission> findPermissionsByUserId(Integer userId);

}
