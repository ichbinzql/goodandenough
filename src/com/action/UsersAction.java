package com.action;

import java.util.List;

import com.bean.Types;
import com.bean.Users;
import com.dao.UsersDao;
import com.dao.typesDao;
import com.opensymphony.xwork2.ActionContext;

public class UsersAction {
	Users us;
	
	public Users getUs() {
		return us;
	}

	public void setUs(Users us) {
		this.us = us;
	}
	
	UsersDao usersDao;
	
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	String msg;
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	typesDao typesDao;
	
	
	public typesDao getTypesDao() {
		return typesDao;
	}

	public void setTypesDao(typesDao typesDao) {
		this.typesDao = typesDao;
	}

	public String login(){
		Users u=usersDao.login(us.getUsername(), us.getPassword());
		if(u!=null){
		List<Types>tlist=typesDao.selectAll();
		ActionContext.getContext().getSession().put("tlist", tlist);
			
			ActionContext.getContext().getSession().put("loginUser", u);
			return "success";
		}else{
			msg="用户名或密码错误";
			return"login";
		}
		
		}
	
	public String checkName(){
		boolean bool=usersDao.checkUsername(us.getUsername());
		if(bool){
			msg="用户名已经被注册";
		}else{
			msg="用户名可以使用";	
		}
		return "result";
		
	}
	
	public String register(){
		usersDao.register(us);
		return "login";
	}
	
}
