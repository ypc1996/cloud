package com.example.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provider.model.Permission;
import com.example.provider.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName UserMapper
 * @Description:
 * @date 2020/11/513:49
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    User findUserByUserName(String username);
    List<Permission> findPermissionsByUserId(Integer userId);
}
