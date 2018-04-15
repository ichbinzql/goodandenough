package com.dao;

import com.bean.Users;

public interface UsersDao {
	public Users login(String username, String password);
	public void register(Users u);
	public boolean checkUsername(String username);

}
