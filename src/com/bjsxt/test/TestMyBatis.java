package com.bjsxt.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.bjsxt.bean.User;
import com.bjsxt.util.MyBatisUtil;

public class TestMyBatis {
	
	/*
	 * 测试selectList
	 */
	@Test
	public void testSelAll()  {
		//加载MyBatis核心配置文件
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//构建SqlSession工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//通过工厂获得SqlSession
		SqlSession session = factory.openSession();
		
		//通过session执行查询操作
		List<User> list = session.selectList("com.bjsxt.mapper.UserMapper.selAll");
		System.out.println(list);
		
		//关闭资源
		session.close();
	}
	
	/*
	 * 测试selectOne
	 */
	@Test
	public void testSelOne()  {
		//加载MyBatis核心配置文件
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//构建SqlSession工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//通过工厂获得SqlSession
		SqlSession session = factory.openSession();
		
		//通过session执行查询操作
		User user = session.selectOne("com.bjsxt.mapper.UserMapper.selOne");
		System.out.println(user);
		
		//关闭资源
		session.close();
	}
	
	/*
	 * 测试selectMap
	 */
	@Test
	public void testSelMap()  {
		//加载MyBatis核心配置文件
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis.xml");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		//构建SqlSession工厂对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		
		//通过工厂获得SqlSession
		SqlSession session = factory.openSession();
		
		//通过session执行查询操作
		Map<Integer,User> map = session.selectMap("com.bjsxt.mapper.UserMapper.selAll","id");
		System.out.println(map);
		
		//遍历map
		Set<Integer>set = map.keySet();
		for (Integer k : set) {
			System.out.println(map.get(k));
		}
		
		//关闭资源
		session.close();
	}
	
	
	/*
	 * 测试parameterType带参查询
	 * param:aaa
	 * 
	 */
	@Test
	public void testParam() {
		//加载MyBatis核心配置文件
				InputStream is = null;
				try {
					is = Resources.getResourceAsStream("mybatis.xml");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				//构建SqlSession工厂对象
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
				
				//通过工厂获得SqlSession
				SqlSession session = factory.openSession();
				
				//通过session执行查询操作
				User user = session.selectOne("com.bjsxt.mapper.UserMapper.selById","aaa");
				System.out.println(user);
				
				//关闭资源
				session.close();
		
	}
	
	/*
	 * 测试parameterType带多个参数查询
	 * param:bbb,456
	 * 
	 */
	@Test
	public void testParam2() {
		//加载MyBatis核心配置文件
				InputStream is = null;
				try {
					is = Resources.getResourceAsStream("mybatis.xml");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				//构建SqlSession工厂对象
				SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
				
				//通过工厂获得SqlSession
				SqlSession session = factory.openSession();
				
				//封装参数
				User u = new User();
				u.setPassword("456");
				u.setUsername("bbb");
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("username", "ccc");
				map.put("password", "789");
				
				//通过session执行查询操作
				User user = session.selectOne("com.bjsxt.mapper.UserMapper.selByUser",u);
				User userByMap = session.selectOne("com.bjsxt.mapper.UserMapper.selByUser", map);
				System.out.println(userByMap);
				
				//关闭资源
				session.close();		
	}
	
	
	/*
	 * 测试insert
	 * param:ddd,111,4
	 */
	@Test
	public void testInsUser()  {
		
		SqlSession session = MyBatisUtil.getSession();
		//封装插入的User
		User u = new User();
		u.setId(4);
		u.setUsername("ddd");
		u.setPassword("111");
		//通过session执行查询操作
		int i = session.insert("com.bjsxt.mapper.UserMapper.insUser",u);
		if(i>0) {
			//提交事务
			session.commit();
			System.out.println("SUCCESS!");			
		}else {
			//回滚事务
			session.rollback();
			System.out.println("FAILED!");
		}
		
		//关闭资源
		MyBatisUtil.closeAll(session);
	}
	
	/*
	 * 测试update
	 * param:eee,4
	 */
	@Test
	public void testUpUser()  {
		
		SqlSession session = MyBatisUtil.getSession();
		//封装插入的User
		User u = new User();
		u.setId(4);
		u.setUsername("eee");		
		//通过session执行查询操作
		int i = session.update("com.bjsxt.mapper.UserMapper.upUser",u);
		if(i>0) {
			//提交事务
			session.commit();
			System.out.println("SUCCESS!");			
		}else {
			//回滚事务
			session.rollback();
			System.out.println("FAILED!");
		}
		
		//关闭资源
		MyBatisUtil.closeAll(session);
	}
	
	/*
	 * 测试delete
	 * param:4
	 * 
	 */
	@Test
	public void testDelUser() {
		SqlSession session = MyBatisUtil.getSession();
		//通过session执行查询操作
		int i = session.delete("com.bjsxt.mapper.UserMapper.delUser",4);
		if(i>0) {
			//提交事务
			session.commit();
			System.out.println("SUCCESS!");			
		}else {
			//回滚事务
			session.rollback();
			System.out.println("FAILED!");
		}
		
		//关闭资源
			MyBatisUtil.closeAll(session);
	}
	
	/*
	 * 测试trim 和bind
	 */
	@Test
	public void testTrim() {
		SqlSession session = MyBatisUtil.getSession();
		//封装插入的User
		User u = new User();
		u.setId(4);
		u.setUsername("a");
		u.setPassword("111");		
		List<User> list = session.selectList("com.bjsxt.mapper.UserMapper.testBind",u);		
		
		for (User user : list) {
			System.out.println(user);
		}
		
		//关闭资源
			MyBatisUtil.closeAll(session);
	}
}
