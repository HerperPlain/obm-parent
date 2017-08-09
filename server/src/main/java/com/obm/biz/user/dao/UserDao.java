package com.obm.biz.user.dao;

import com.obm.biz.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {

    @Query(value = "select u from UserEntity u where username=?1 and passwd=?2")
    UserEntity queryLogin(String username,String passwd);
}
