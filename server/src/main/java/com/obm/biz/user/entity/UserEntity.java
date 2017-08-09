package com.obm.biz.user.entity;

import com.obm.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
public class UserEntity extends BaseEntity {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "username")
    private String username;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "email")
    private String email;
    @Column(name = "enable")
    private boolean enable;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "last_login_ip")
    private String lastLoginIp;
    @Column(name = "head_pic")
    private String headPic;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public UserEntity(String userId ,String username, String passwd, String nickname, String email, boolean enable, int showOrder, String createUser, Date createTime, String updateUser, Date updateTime, Date lastLoginTime, String lastLoginIp, String headPic) {
        this.userId=userId;
        this.username = username;
        this.passwd = passwd;
        this.nickname = nickname;
        this.email = email;
        this.enable = enable;
        this.showOrder = showOrder;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.lastLoginTime = lastLoginTime;
        this.lastLoginIp = lastLoginIp;
        this.headPic = headPic;
    }

    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", enable=" + enable +
                ", showOrder=" + showOrder +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", lastLoginTime=" + lastLoginTime +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", headPic='" + headPic + '\'' +
                '}';
    }
}

