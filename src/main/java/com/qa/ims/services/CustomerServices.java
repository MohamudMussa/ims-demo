package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer> {

	private Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	
	public List<Customer> readAll() {
		return customerDao.readAll();
	}

	public Customer create(Customer customer) {
		return customerDao.create(customer);
	}

	public Customer update(Customer customer) {
		return customerDao.update(customer);
	}

	public void delete(Long customer_id) {
		customerDao.delete(customer_id);
	}

	@Override
	public Customer additems(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Long order_id1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer updateOrderline(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void calculateOrder(Long order_id1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer calculateOrder(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
