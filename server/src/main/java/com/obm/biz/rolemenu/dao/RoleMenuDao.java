package com.obm.biz.rolemenu.dao;

import com.obm.biz.rolemenu.entity.RoleMenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMenuDao extends JpaRepository<RoleMenuEntity,String>{
    List<RoleMenuEntity> queryRoleMenuEntitiesByRoleId(String roleId);
}
