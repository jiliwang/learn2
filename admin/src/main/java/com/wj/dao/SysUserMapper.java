package com.wj.dao;



import com.wj.entity.SysMenu;
import com.wj.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(SysUser record);
//
//    int insertSelective(SysUser record);
//
    SysUser selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(SysUser record);
//
//    int updateByPrimaryKey(SysUser record);
//
//    List<SysUser> findPage();
//
//    SysUser findByName(@Param(value = "name") String name);
//    
//	List<SysUser> findPageByName(@Param(value = "name") String name);
//
//	List<SysUser> findPageByNameAndEmail(@Param(value = "name") String name, @Param(value = "email") String email);

    /**
     * 查询全部
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 分页查询
     * @return
     */
    List<SysUser> selectPage();
}