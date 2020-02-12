package com.bjsxt.util;

import java.io.IOException;

import javax.xml.transform.Source;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory = null;
	
	static {
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static SqlSession getSession() {
		SqlSession session = null;
		if(factory!=null) {
			//如果factory为空会报空指针异常
			session = factory.openSession();
		}
		return session;
	}
	
	public static void closeAll(SqlSession session) {
		session.close();
	}
}
