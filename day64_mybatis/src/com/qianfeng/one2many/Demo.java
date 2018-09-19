package com.qianfeng.one2many;

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
//		demo.findDeptById2();
		
		demo.addInfo();
	}
	
	public void findDeptById(){
		SqlSession session = sessionFactory.openSession();
		IDepartmentDao deptDao = session.getMapper(IDepartmentDao.class);
		
		Department dept = deptDao.findById(1);
		System.out.println(dept.getDname());
		System.out.println(dept);
		System.out.println(dept.getEmps().get(0).getDept());
//		System.out.println(dept.getEmps().size());
//		System.out.println(dept.getEmps().get(0).getEname());
//		System.out.println(dept.getEmps().get(0).getDept().getDname());
		
		session.close();
		
		
		
	}
	
	public void findDeptById2(){
		SqlSession session = sessionFactory.openSession();
		IDepartmentDao deptDao = session.getMapper(IDepartmentDao.class);
		
		Department dept = deptDao.findById2(1);
		System.out.println(dept.getDname());
		System.out.println(dept.getEmps().size());
		System.out.println(dept.getEmps().get(0).getEname());
		System.out.println(dept.getEmps().get(0).getDept().getDname());
		
		session.close();
		
	}
	
	public void addInfo(){
		SqlSession session = sessionFactory.openSession();
		IDepartmentDao mapper = session.getMapper(IDepartmentDao.class);
		
		Department dept = new Department();
		dept.setDname("xiaoshou");
		
//		mapper.add(dept);
		mapper.add1(dept);
		// 打印自增的id
		System.out.println(dept.getDid());
		
		Employee emp = new Employee();
		emp.setEname("aaa");
		emp.setDept(dept);
		
		session.commit();
		session.close();
		
	}

}
