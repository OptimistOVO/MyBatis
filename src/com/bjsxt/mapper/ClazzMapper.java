package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bjsxt.bean.Clazz;

public interface ClazzMapper {
	
	/**
	 * 
	 * @Title: selById   
	 * @Description:根据班级id查询班级信息
	 * @param id
	 * @return Clazz      
	 * @throws
	 */
	Clazz selById(@Param("id") int id);
}
