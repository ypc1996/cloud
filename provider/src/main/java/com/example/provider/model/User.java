package com.example.provider.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author yangpengcheng
 * @ClassName User
 * @Description:
 * @date 2020/11/513:47
 */
@Data
@TableName("sys_user")
public class User {
    private Integer id;
    private String username;
    private String password;
    @TableField("full_name")
    private String fullName;
    private String mobile;
}
