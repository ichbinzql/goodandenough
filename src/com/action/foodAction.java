package com.action;

import java.util.List;

import com.bean.Food;
import com.dao.foodDao;



public class foodAction {
	foodDao foodDao;
	public foodDao getFoodDao() {
		return foodDao;
	}
	public void setFoodDao(foodDao foodDao) {
		this.foodDao = foodDao;
	}

	List<Food> foodlist;
	public List<Food> getFoodlist() {
		return foodlist;
	}

	public void setFoodlist(List<Food> foodlist) {
		this.foodlist = foodlist;
	}

	public String selectAll(){
		foodlist=	foodDao.selectAll();
		return "show";
		
	}
	
	Integer id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String selectByTypes(){
	foodlist=   foodDao.selectByTypes(id);
	return "show";
	}
	
	Integer typesId; 
	String name;
	public Integer getTypesId() {
		return typesId;
	}
	public void setTypesId(Integer typesId) {
		this.typesId = typesId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String selectByNameOrType(){
	foodlist=	foodDao.selectByNameOrType(name, typesId);
	return "show";
	}
	
}
