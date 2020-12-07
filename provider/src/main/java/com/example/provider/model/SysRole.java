package com.example.provider.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
@Data
public class SysRole {
    private Integer id;

    private String roleName;

    private boolean isSuccess;

    public SysRole(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public SysRole() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}