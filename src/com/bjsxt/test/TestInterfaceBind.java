package com.bjsxt.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.bjsxt.bean.User;
import com.bjsxt.mapper.UserMapper;
import com.bjsxt.util.MyBatisUtil;

public class TestInterfaceBind {

	@Test
	public void testSelectBind() {
		// 获取SqlSession对象
		SqlSession session = MyBatisUtil.getSession();
		// 获取UserMapper接口的实现类对象
		UserMapper mapper = session.getMapper(UserMapper.class);

//				List<User> list = mapper.selectAll();
//				for (User user : list) {
//					System.out.println(user);
//				}
		/*
		 * 测试接口绑定————多个参数
		 */
//		User u = mapper.selectById("aaa", "123");
//		System.out.println(u);
		
		/*
		 * 测试动态SQL
		 */
//		List<User> list = mapper.selDongTai("", "");
//		for (User user : list) {
//			System.out.println(user);
//		}
		
//		User user = new User();
//		user.setId(3);
//		user.setPassword("789");
//		user.setUsername("ddd");
//		int i = mapper.updUser(user);
//		if(i>0) {
//			session.commit();
//			System.out.println("SUCCESS!");
//		}else {
//			session.rollback();
//			System.out.println("FAILED!");
//		}
		
		
		/*
		 * 测试foreach
		 */
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		List<User> l = mapper.testForeach(list);
		for (User user : l) {
			System.out.println(user);
		}
	}
	
}
