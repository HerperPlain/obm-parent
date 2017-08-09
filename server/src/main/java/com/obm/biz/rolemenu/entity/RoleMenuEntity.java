package com.obm.biz.rolemenu.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
