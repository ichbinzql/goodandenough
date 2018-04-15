package com.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Order;

public class orderDaoImpl extends HibernateDaoSupport implements orderDao {

	@Transactional
	public void add(Order o) {
		getHibernateTemplate().save(o);
		
	}

}
