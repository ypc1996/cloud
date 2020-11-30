package com.example.provider.security;

import com.alibaba.fastjson.JSON;
import com.example.provider.model.Permission;
import com.example.provider.model.User;
import com.example.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName MyUserDetailsService
 * @Description:
 * @date 2020/11/417:51
 */
@Configuration
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据账号去数据库查询...
        User user = userService.findUserByUserName(s);
        if(user == null){
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        List<Permission> permissions=userService.findPermissionsByUserId(user.getId());
        //将permissions转成数组
        List<SimpleGrantedAuthority> grantedAuthority=new ArrayList<>();
        for(Permission permission:permissions){
            SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(permission.getCode());
            grantedAuthority.add(simpleGrantedAuthority);
        }
        //将userDto转成json
        String principal = JSON.toJSONString(user);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthority);
    }
}
