package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

public class OrderServices implements CrudServices<Order> {

	private Dao<Order> orderDao;
	
	public OrderServices(Dao<Order> OrderDao) {
		this.orderDao = OrderDao;
	}
	
	public List<Order> readAll() {
		return orderDao.readAll();
	}

	public Order create(Order Order) {
		return orderDao.create(Order);
	}
	

	public Order update(Order Order) {
		return orderDao.update(Order);
	}

	public void delete(Long Order_id) {
		orderDao.delete(Order_id);
	}
	
	//new service
	
	public Order creatingOrder(Order Orderline) {
		return orderDao.create(Orderline);
		
	}

}
