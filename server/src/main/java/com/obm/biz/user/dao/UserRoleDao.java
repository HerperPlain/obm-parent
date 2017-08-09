package com.obm.biz.user.dao;

import com.obm.biz.user.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleDao  extends JpaRepository<UserRoleEntity,String>{
    List<UserRoleEntity> queryUserRoleEntitiesByUserId(String userId);
}
