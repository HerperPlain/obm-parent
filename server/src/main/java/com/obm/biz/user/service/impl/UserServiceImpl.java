package com.obm.biz.user.service.impl;

import com.obm.biz.rolemenu.dao.RoleMenuDao;
import com.obm.biz.rolemenu.entity.RoleMenuEntity;
import com.obm.biz.user.dao.UserDao;
import com.obm.biz.user.dao.UserRoleDao;
import com.obm.biz.user.entity.UserEntity;
import com.obm.biz.user.entity.UserRoleEntity;
import com.obm.biz.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    UserRoleDao userRoleDao;
    @Autowired
    RoleMenuDao roleMenuDao;
    @Override
    public UserEntity queryLogin(UserEntity model) {
        return userDao.queryLogin(model.getUsername(),model.getPasswd());
    }

    public List<RoleMenuEntity> queryRoleMenuEntitysByRoleId(String roleId){
        return roleMenuDao.queryRoleMenuEntitiesByRoleId(roleId);
    }

    public List<UserRoleEntity> queryUserRoleEntitysByUserId(String userId){
        return userRoleDao.queryUserRoleEntitiesByUserId(userId);
    }

}
