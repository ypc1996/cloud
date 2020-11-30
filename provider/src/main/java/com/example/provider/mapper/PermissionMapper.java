package com.example.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.provider.model.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yangpengcheng
 * @ClassName PermissionMapper
 * @Description:
 * @date 2020/11/516:42
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    List<Permission> findAllUrl();
}
