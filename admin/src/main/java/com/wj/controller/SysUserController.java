package com.wj.controller;

import com.wj.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Transactional
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource(name = "sysUserServiceImpl")
    private SysUserService sysUserService;

//    @GetMapping(value="/findByUserId")
//    public Object findByUserId(@RequestParam Long userId) {
//        return sysUserService.findByUserId(userId);
//    }

    @GetMapping(value="/findAll")
    public Object findAll() {

        return sysUserService.findAll();
    }

}
