package com.qianfeng.one2one;

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
//		demo.findPersonByid();
		demo.findPersonByid2();
	}
	
	public void findPersonByid(){
		SqlSession session = sessionFactory.openSession();
		IPersonDao mapper = session.getMapper(IPersonDao.class);
		
		Person person = mapper.findById(1);
		
		System.out.println(person.getPname());
		System.out.println(person.getCard().getCnum());
		
		session.close();
		
		
	}
	
	public void findPersonByid2(){
		SqlSession session = sessionFactory.openSession();
		IPersonDao mapper = session.getMapper(IPersonDao.class);
		
		Person person = mapper.findById2(1);
		
		System.out.println(person.getPname());
		System.out.println(person.getCard().getCnum());
		
		session.close();
		
		
	}

}
