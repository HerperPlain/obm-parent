package com.obm.biz.menu.dao;

import com.obm.biz.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDao extends JpaRepository<MenuEntity, String> {
}
