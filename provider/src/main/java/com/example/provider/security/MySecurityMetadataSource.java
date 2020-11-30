package com.example.provider.security;

import com.example.provider.mapper.PermissionMapper;
import com.example.provider.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName MySecurityMetadataSource
 * @Description:
 * @date 2020/11/516:35
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionMapper permissionMapper;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        //获取请求的url
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Permission> allUrl = permissionMapper.findAllUrl();
        List<String> grantedAuthorities=new ArrayList<>();
        for(Permission permission:allUrl){

            if(antPathMatcher.match(permission.getUrl(),requestUrl)){
                grantedAuthorities.add(permission.getCode());
            }

        }
        return SecurityConfig.createList(grantedAuthorities.toArray(new String[grantedAuthorities.size()]));
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}
