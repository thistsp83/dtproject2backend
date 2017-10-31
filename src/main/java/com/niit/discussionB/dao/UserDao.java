package com.niit.discussionB.dao;

import java.util.List;

import com.niit.discussionB.model.User;

public interface UserDao 
{
	public User get(String id);
	public void save(User u);
	public boolean update(User u);
	public List<User> list();
	public List<User> listUsers(String user);
	public boolean validate(String id,String password);


}
