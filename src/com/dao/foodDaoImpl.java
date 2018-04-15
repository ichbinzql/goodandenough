package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Food;

public class foodDaoImpl extends HibernateDaoSupport implements foodDao {

	@Transactional
	public void add(Food f) {
		
		getHibernateTemplate().save(f);
	}
	@Transactional
	public void delete(Food f) {
		getHibernateTemplate().delete(f);
		
	}

	@Transactional
	public void update(Food f) {
		getHibernateTemplate().update(f);

		
	}


	public List<Food> selectAll() {
		return getHibernateTemplate().find("from Food"); //本来就是查询到集合，直接from Food
		
	}


	public List<Food> selectByTypes(int TypesId) {
		return getHibernateTemplate().find("from Food where types.id=?",TypesId);
		
	}


	public Food selectById(int id) {
		
		return getHibernateTemplate().get(Food.class, id);
	}

	public List<Food> selectByNameOrType(String name, Integer typesId) {
		if(typesId==0){
			return	getHibernateTemplate().find("from Food where name like?","%"+name+"%");
		}else{
			return getHibernateTemplate().find("from Food where name like? and types.id=?","%"+name+"%",typesId);
		}
	
		
	}

}
