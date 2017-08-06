package com.obm.user.service;

import com.obm.user.entity.UserEntity;

public interface UserService {

    UserEntity queryLogin(UserEntity model);
}
