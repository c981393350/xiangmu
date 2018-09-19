package com.qianfeng.one2many;

public interface IDepartmentDao {

	public Department findById(int id);
	
	public Department findById2(int id);
	
	public void add(Department dept);
	public void add1(Department dept);
	
	
}
