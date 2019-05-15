package com.jk.model;

import java.io.Serializable;

public class RolePawer  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer roleId;

    private Integer powerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPowerId() {
        return powerId;
    }

    public void setPowerId(Integer powerId) {
        this.powerId = powerId;
    }

    @Override
    public String toString() {
        return "RolePawer [id=" + id + ", roleId=" + roleId + ", powerId=" + powerId + "]";
    }
}
