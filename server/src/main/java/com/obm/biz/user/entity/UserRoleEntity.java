package com.obm.biz.user.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sys_user_role")
public class UserRoleEntity extends BaseEntity {
    @Id
    @Column(name = "user_role_id")
    private String userRoleId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "role_id")
    private String roleId;
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
    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public UserRoleEntity(String userRoleId, String userId, String roleId) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public UserRoleEntity() {
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRoleId='" + userRoleId + '\'' +
                ", userId='" + userId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", showOrder=" + showOrder +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
