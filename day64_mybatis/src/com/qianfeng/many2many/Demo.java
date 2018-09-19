package com.qianfeng.many2many;

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
//		demo.findDeptById();
		demo.findDeptById2();
	}
	
	public void findDeptById(){
		SqlSession session = sessionFactory.openSession();
		IStudentDao mapper = session.getMapper(IStudentDao.class);
		
		Student student = mapper.findById(1);
		System.out.println(student.getSname());
		System.out.println(student.getCourseList().size());
		System.out.println(student.getCourseList().get(0).getCname());
		
		session.close();
		
	}
	
	public void findDeptById2(){
		SqlSession session = sessionFactory.openSession();
		
		IStudentDao mapper = session.getMapper(IStudentDao.class);
		
		Student student = mapper.findById2(1);
		System.out.println(student.getSname());
		System.out.println(student.getCourseList().size());
		System.out.println(student.getCourseList().get(0).getCname());
		
		
		session.close();
		
		
		
	}

}
