package com.dao;

import java.util.List;

import com.bean.Food;

public interface foodDao {
	public void add(Food f);
	public void delete(Food f);
	public void update(Food f);
	public List<Food> selectAll();
	public List<Food> selectByTypes(int TypesId);
	public Food selectById(int id);
	public List<Food>selectByNameOrType(String name,Integer typesId);
}
