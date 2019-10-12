package com.wj.service;

import com.wj.entity.SysUser;


import java.util.List;

public interface SysUserService {
    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    SysUser findByUserId(Long userId);

    /**
     * 查找所有用户
     * @return
     */
    List<SysUser> findAll();
}
