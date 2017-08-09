package com.obm.biz.user.service;

import com.obm.biz.user.entity.UserEntity;

public interface UserService {

    UserEntity queryLogin(UserEntity model);
}
