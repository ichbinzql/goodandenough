package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bean.Types;

public class typesDaoImpl extends HibernateDaoSupport implements typesDao{

	@Override
	public List<Types> selectAll() {
		// TODO Auto-generated method stub
		return getHibernateTemplate().find("from Types");
	}

}
