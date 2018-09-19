package com.qianfeng.many2many2;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Demo {
	
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
		// TODO Auto-generated method stub
		Demo demo = new Demo();
	}
	
	

}
