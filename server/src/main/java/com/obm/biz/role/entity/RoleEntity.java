package com.obm.biz.role.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sys_role")
public class RoleEntity extends BaseEntity {
    @Id
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "role_name")
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public RoleEntity() {
    }

    public RoleEntity(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId='" + roleId + '\'' +
                ", roleName='" + roleName + '\'' +
                ", showOrder=" + showOrder +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
