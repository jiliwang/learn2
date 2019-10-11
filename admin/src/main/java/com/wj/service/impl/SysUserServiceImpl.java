package com.wj.service.impl;

import com.wj.dao.SysUserMapper;
import com.wj.entity.SysUser;
import com.wj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service("sysUserServiceImpl")
public class SysUserServiceImpl implements SysUserService {
    @Resource(name = "sysUserMapperImpl")
    private SysUserMapper sysUserMapper;

//    @Override
//    public SysUser findByUserId(Long userId) {
//        return sysUserMapper.selectByPrimaryKey(userId);
//    }

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }

}
