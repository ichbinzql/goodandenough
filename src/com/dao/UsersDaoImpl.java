package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {

public Users login(String username, String password) {
	List<Users>list=getHibernateTemplate().find("from Users where username=?and password=?",username,password);
	return list.size()>0 ?list.get(0):null;
}




	@Transactional
	public void register(Users u) {

	getHibernateTemplate().save(u);//delete(u) update(u);
		
	}

	

	@Transactional
	public boolean checkUsername(String username) {
	List<Users>list=getHibernateTemplate().find("from Users where username=?",username);
	
	return list.size()>0?true:false;
	}
}
