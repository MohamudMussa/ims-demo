package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Order;

@RunWith(MockitoJUnitRunner.class)
public class OrderServicesTest {

	@Mock
	private Dao<Order> customerDao;

	@InjectMocks
	private OrderServices OrderServices;

	@Test
	public void OrderServicesCreate() {
		Order order = new Order(1L, 2L, 8, 8);
		OrderServices.create(order);
		Mockito.verify(customerDao, Mockito.times(1)).create(order);
	}

	@Test
	public void OrderServicesRead() {
		OrderServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}

	@Test
	public void OrderServicesUpdate() {
		Order order = new Order(1L, 2L, 8, 8);
		OrderServices.update(order);
		Mockito.verify(customerDao, Mockito.times(1)).update(order);
	}

	@Test
	public void OrderServicesDelete() {
		OrderServices.delete(1L);
		;
		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
	}
}
