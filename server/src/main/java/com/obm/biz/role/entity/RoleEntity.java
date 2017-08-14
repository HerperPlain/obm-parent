package com.obm.biz.role.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sys_role")
public class RoleEntity extends BaseEntity {
    @Id
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "show_order")
    public int showOrder;
    @Column(name = "create_user")
    public String createUser;
    @Column(name = "create_time")
    public Date createTime;
    @Column(name = "update_user")
    public String updateUser;
    @Column(name = "update_time")
    public Date updateTime;
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

    public int getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(int showOrder) {
        this.showOrder = showOrder;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
