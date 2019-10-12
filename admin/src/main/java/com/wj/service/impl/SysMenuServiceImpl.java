package com.wj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wj.dao.SysMenuMapper;
import com.wj.entity.SysMenu;
import com.wj.page.PageRequest;
import com.wj.page.PageResult;
import com.wj.page.PageUtils;
import com.wj.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysMenuServiceImpl")
public class SysMenuServiceImpl implements SysMenuService {

    @Resource(name = "sysMenuMapperImpl")
    private SysMenuMapper sysMenuMapper;

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    private PageInfo<SysMenu> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysMenu> sysMenus = sysMenuMapper.selectPage();
        return new PageInfo<SysMenu>(sysMenus);
    }




}
