package com.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Users;

public class test2 {


	public static void main(String[] args) {
		//1.加载spring配置文件
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	UsersDao ud=	(UsersDao) ac.getBean("usersDao");
	Users u= ud.login("lisi", "123");
	if(u!=null){
		System.out.println("欢迎"+u.getNickname()+"登录");
	}else{
		System.out.println("用户名或密码错误，重新登录");
	}
	
	if(ud.checkUsername("wanger")){
		System.out.println("用户名已被注册");
	}else{
		System.out.println("用户名可以使用");
	}
	
	ud.register(new Users("wanger", "王二", "123", "jxfcgc@163.com", "15717004279", 0, null));
	
}
}