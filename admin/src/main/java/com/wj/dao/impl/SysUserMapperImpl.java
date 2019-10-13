package com.wj.dao.impl;


import com.wj.dao.SysUserMapper;
import com.wj.entity.SysMenu;
import com.wj.entity.SysUser;
import com.wj.service.SysUserService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("sysUserMapperImpl")
public class SysUserMapperImpl implements SysUserMapper {
    @Resource(name = "dbSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;


    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sqlSessionTemplate.selectOne("com.wj.dao.SysUserMapper.selectByPrimaryKey",id);
    }

    @Override
    public List<SysUser> selectAll() {
        return sqlSessionTemplate.selectList("selectAll");
    }

    @Override
    public List<SysUser> selectPage() {
        return sqlSessionTemplate.selectList("selectPage");
    }
}
