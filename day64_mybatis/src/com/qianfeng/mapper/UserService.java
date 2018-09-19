package com.qianfeng.mapper;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserService {

	private static SqlSessionFactory sessionFactory;
	static{
		// 读取配置文件，获取Reader对象
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取SqlSessionFactory对象
		sessionFactory = new SqlSessionFactoryBuilder().build(reader);
					
	}
	
	public static void main(String[] args) {
		UserService us = new UserService();
//		us.addUser();
		us.findAllUser();
	}
	
	public void addUser(){
		SqlSession session = sessionFactory.openSession();
		// 获取接口的映射对象
		IUserDao userDao = session.getMapper(IUserDao.class);
		
		User u = new User();
		u.setUname("haha");
		// 直接调用接口中方法
		userDao.add(u);
		
		session.commit();
		session.close();
	}
	
	public void findAllUser(){
		SqlSession session = sessionFactory.openSession();
		IUserDao mapper = session.getMapper(IUserDao.class);
		
		List<User> list = mapper.findAll();
		System.out.println(list.size());
		
		session.close();
	}
}
