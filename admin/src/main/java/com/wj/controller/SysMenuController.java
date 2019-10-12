package com.wj.controller;

import com.wj.page.PageRequest;
import com.wj.service.SysMenuService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Resource(name = "sysMenuServiceImpl")
    private SysMenuService sysMenuService;


    @PostMapping(value="/findPage")
    public Object findPage(@RequestBody PageRequest pageQuery) {
        return sysMenuService.findPage(pageQuery);
    }
}
