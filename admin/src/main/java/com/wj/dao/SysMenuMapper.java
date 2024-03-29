package com.wj.dao;


import com.wj.entity.SysMenu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface SysMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);
    
	List<SysMenu> findPage();

	List<SysMenu> findPageByName(@Param(value = "name") String name);
	
	List<SysMenu> findAll();

	List<SysMenu> findByUserName(@Param(value = "userName") String userName);

	List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    /**
     * 分页查询
     * @return
     */
    List<SysMenu> selectPage();
}