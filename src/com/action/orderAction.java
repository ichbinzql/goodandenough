package com.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bean.Food;
import com.bean.Order;
import com.bean.Orderdetail;
import com.bean.Users;
import com.dao.foodDao;
import com.dao.orderDao;
import com.opensymphony.xwork2.ActionContext;

public class orderAction {
orderDao orderDao;
foodDao foodDao;
Integer []quantity; //获取用户购物车中每一个食物额数量

Integer [] ids;   //获取用户购物车中每一个食物的id



	public String addOrder(){
		Order o=new Order();
		Users u=(Users) ActionContext.getContext().getSession().get("loginUser");
		o.setUsers(u); //设置下单用户
		o.setOrderTime(new Date()); //设置下单时间
		Set<Orderdetail>set=new HashSet<Orderdetail>(); //创建订单细节的集合
		for (int i = 0; i < quantity.length; i++) { //循环输出用户点餐内容
			Food f=foodDao.selectById(ids[i]);  //根据获取食物id得到食物对象
			Orderdetail od=new Orderdetail(f, o, quantity[i], f.getPrice()*quantity[i]);  //把食物对象做成订单细节
			set.add(od);  //把订单细节加入集合
		}
		o.setOrderdetails(set); //设置订单细节
		orderDao.add(o);     //把订单数据加入数据库
		
		return "success";
	}
	
	
	
	
	
	public orderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(orderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	
	public Integer[] getQuantity() {
	return quantity;
}

public void setQuantity(Integer[] quantity) {
	this.quantity = quantity;
}

public Integer[] getIds() {
	return ids;
}

public void setIds(Integer[] ids) {
	this.ids = ids;
}





public foodDao getFoodDao() {
	return foodDao;
}

public void setFoodDao(foodDao foodDao) {
	this.foodDao = foodDao;
}





	
	
	
}
