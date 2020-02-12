package com.bjsxt.service;

import java.util.List;

import com.bjsxt.bean.Student;

public interface StudentService {
	
	/*
	 * Service层处理业务逻辑
	 */
	List<Student> selAll();
}
