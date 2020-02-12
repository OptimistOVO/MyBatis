package com.bjsxt.test;

import java.util.List;

import com.bjsxt.bean.Student;
import com.bjsxt.service.StudentService;
import com.bjsxt.service.impl.StudentServiceImpl;

public class TestQuery {
	public static void main(String[] args) {
		StudentService ss = new StudentServiceImpl();
		List<Student> list = ss.selAll();
		
		for (Student student : list) {
			System.out.println(student);
		}
	}
}
