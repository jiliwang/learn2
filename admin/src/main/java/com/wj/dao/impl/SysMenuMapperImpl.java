package com.wj.dao.impl;

import com.wj.dao.SysMenuMapper;
import com.wj.entity.SysMenu;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("sysMenuMapperImpl")
public class SysMenuMapperImpl implements SysMenuMapper {
    @Resource(name = "dbSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(SysMenu record) {
        return 0;
    }

    @Override
    public int insertSelective(SysMenu record) {
        return 0;
    }

    @Override
    public SysMenu selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return 0;
    }

    @Override
    public List<SysMenu> findPage() {
        return null;
    }

    @Override
    public List<SysMenu> findPageByName(String name) {
        return null;
    }

    @Override
    public List<SysMenu> findAll() {
        return null;
    }

    @Override
    public List<SysMenu> findByUserName(String userName) {
        return null;
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        return null;
    }

    @Override
    public List<SysMenu> selectPage() {
        return sqlSessionTemplate.selectList("selectPage");
    }
}
