package com.bjsxt.mapper;

import java.util.List;

import com.bjsxt.bean.Student;

public interface StudentMapper {
	/**
	 * 
	 * @Title: selAll   
	 * @Description: 查询所有学生
	 * @return List<Student>      
	 * @throws
	 */
	List<Student> selAll();
	
	List<Student> selAll3();
}
