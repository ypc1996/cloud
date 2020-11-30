package com.example.provider.model;

import lombok.Data;

/**
 * @author yangpengcheng
 * @ClassName Permission
 * @Description:
 * @date 2020/11/513:49
 */
@Data
public class Permission {
    private Integer id;
    private String code;
    private String description;
    private String url;
    private String name;
    private String type;
    private Integer patientId;
}
