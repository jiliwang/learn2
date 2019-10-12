package com.wj.service;


import com.wj.page.PageRequest;
import com.wj.page.PageResult;

/**
 * 菜单管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysMenuService {

//	/**
//	 * 查询菜单树,用户ID和用户名为空则查询全部
//	 * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
//	 * @param userId
//	 * @return
//	 */
//	List<SysMenu> findTree(String userName, int menuType);
//
//	/**
//	 * 根据用户名查找菜单列表
//	 * @param userName
//	 * @return
//	 */
//	List<SysMenu> findByUser(String userName);

	/**
	 * 分页查询接口
	 * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
	 * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
	 * 影响服务层以上的分页接口，起到了解耦的作用
	 * @param pageRequest 自定义，统一分页查询请求
	 * @return PageResult 自定义，统一分页查询结果
	 */
	PageResult findPage(PageRequest pageRequest);
}
