package com.obm.common.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable{

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
}
