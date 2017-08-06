package com.obm.user.service.impl;

import com.obm.user.dao.UserDao;
import com.obm.user.entity.UserEntity;
import com.obm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public UserEntity queryLogin(UserEntity model) {
        return userDao.queryLogin(model.getUsername(),model.getPasswd());
    }
}
