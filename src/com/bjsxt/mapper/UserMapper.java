package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.bean.User;

public interface UserMapper {
	/*
	 * 查询所有用户
	 */
	List<User> selectAll();
	/*
	 * 根据用户名密码查询用户信息
	 */
	User selectById(@Param("username") String username,@Param("password") String password);
	
	/**
	 * 
	 * @Title: selDongTai
	 * @Description: 利用动态SQL实现where后面根据情况添加
	 * @param username
	 * @param password
	 * @return List<User>
	 * @throws
	 */
	List<User> selDongTai(@Param("username") String username,@Param("password") String password);
	
	/**
	 * 
	 * @Title: updUser   
	 * @Description: 更新用户
	 * @param user
	 * @return int      
	 * @throws
	 */
	int updUser(User user);
	
	/**
	 * 
	 * @Title: testForeach   
	 * @Description:利用动态SQL的foreach标签，实现查找用户
	 * @param list
	 * @return List<User>      
	 * @throws
	 */
	List<User> testForeach(List<Integer> list);
}
