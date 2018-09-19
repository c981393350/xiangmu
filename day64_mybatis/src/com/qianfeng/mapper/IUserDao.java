package com.qianfeng.mapper;

import java.util.List;

public interface IUserDao {
	
	public void add(User user);
	
	List<User> findAll();
}
