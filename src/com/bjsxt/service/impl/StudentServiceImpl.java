package com.bjsxt.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bjsxt.bean.Student;
import com.bjsxt.mapper.ClazzMapper;
import com.bjsxt.mapper.StudentMapper;
import com.bjsxt.service.StudentService;
import com.bjsxt.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService{
	
	/*
	 * 
	 */
	@Override
	public List<Student> selAll() {
		SqlSession session = MyBatisUtil.getSession();
		//获取学生mapper
		StudentMapper stuMapper = session.getMapper(StudentMapper.class);
		//获取班级mapper
//		ClazzMapper clsMapper = session.getMapper(ClazzMapper.class);
		
		List<Student> list = stuMapper.selAll3();
		//wei为每一个student组装班级信息
//		for (Student student : list) {
//			;
//			student.setClazz(clsMapper.selById(student.getCid()));
//		}
		session.close();
		return list;
	}
	
}
