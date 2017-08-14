package com.obm.biz.rolemenu.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sys_role_menu")
public class RoleMenuEntity extends BaseEntity {
    @Id
    @Column(name = "role_meun_id")
    private String roleMeunId;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "menu_id")
    private String menuId;
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

    public String getRoleMeunId() {
        return roleMeunId;
    }

    public void setRoleMeunId(String roleMeunId) {
        this.roleMeunId = roleMeunId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
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

    public RoleMenuEntity(String roleMeunId, String roleId, String menuId) {
        this.roleMeunId = roleMeunId;
        this.roleId = roleId;
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenuEntity{" +
                "roleMeunId='" + roleMeunId + '\'' +
                ", roleId='" + roleId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", showOrder=" + showOrder +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }
}
