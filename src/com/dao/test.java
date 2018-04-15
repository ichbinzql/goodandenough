package com.dao;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Food;
import com.bean.Order;
import com.bean.Orderdetail;
import com.bean.Users;

public class test {

	
	public static void main(String[] args) {
		//1.加载spring配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.从spring中获取需要的类
	/*	aaa a=(aaa) ac.getBean("aaa");//测试aaa类输出什么
		a.show();
		UsersDao ud= (UsersDao) ac.getBean("usersDao"); //测试UsersDaoImpl类的方法
		
		if(ud.checkUsername("ge")){
			System.out.println("用户名已经被注册");
		}else{
			System.out.println("用户名可以使用");
		}
		
		Users u= ud.login("ge", "123");
		if(u!=null){
			System.out.println("欢迎"+u.getNickname());
		}else{
			System.out.println("用户名或者密码错误");
		}*/
		
	/*	UsersDao ud=(UsersDao) ac.getBean("usersDao");
		Users u=new Users("ge", "葛聪", "123", "jxfcgc@163.com", "15717004279", 0, null);
		ud.register(u);*/

		
//FoodDao的测试
	//	foodDao fd=(foodDao) ac.getBean("foodDao");
	//	fd.add(new Food(null, "可口可乐", "", "可口可乐公司出品", 3.0, "", 0, 5, null));
		
		/*List<Food>list=	fd.selectAll();
		for (Food f : list) {
			System.out.println(f.getName());
		}*/
		
		/*List<Food>list=	fd.selectByTypes(1);
		for (Food f : list) {
			System.out.println(f.getName());
		}*/
		
		/*Food f= fd.selectById(2); //根据id查询
		f.setName("冰红茶");
		fd.update(f);			//更改功能
		*/
		//fd.delete(fd.selectById(2)); //删除功能

		UsersDao ud=(UsersDao) ac.getBean("usersDao");
		foodDao fd=(foodDao) ac.getBean("foodDao");
		orderDao od=(orderDao) ac.getBean("orderDao");
		Scanner in=new Scanner(System.in);
	//1.登录	
		System.out.println("请输入用户名");
		String username=in.next();
		System.out.println("请输入密码");
		String password=in.next();
		Users u=ud.login(username, password);
	//2.显示菜品给用户看
		if(u!=null){
			List<Food>list=fd.selectAll();
			for (int i = 0; i < list.size(); i++) {
			System.out.println((i+1)+"."+list.get(i).getName());	
			}

	//3.点餐	
		Set<Orderdetail>set=new HashSet<Orderdetail>(); //装订单细节的集合
		 Order o=new Order(u, new Date(), "a15-260", set);//创建一笔订单
		 while(1==1){
			System.out.println("请选择想吃的食物序号");
			int index=in.nextInt();
			System.out.println("请输入食物数量");
			int nums=in.nextInt();
			Food f=list.get(index-1); //获取到用户点的食物
			set.add(new Orderdetail(f, o, nums, f.getPrice()*nums)); //把点餐的数据转化为订单的细节
			System.out.println("是否继续点餐y/n");
			String yn=in.next();
			if(yn.equals("n")){
				break;
			}
		}
		 od.add(o); //用户完全点餐完毕后，把订单加入数据库（配置集联cascade="all"）
		 System.out.println("感谢您的订单，您的总价为");
		}else{
			System.out.println("用户名或密码错误，请重新登录！");
		}
		
	List<Food>list=	fd.selectByNameOrType("可乐", 0);
		for (Food f : list) {
			System.out.println(f.getName());
		}
		
		
	}
	
}
