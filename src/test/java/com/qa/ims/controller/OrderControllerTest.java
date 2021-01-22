package com.qa.ims.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.OrderServices;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

	/**
	 * The thing I want to fake functionality for
	 */
	@Mock
	private OrderServices OrderServices;

	/**
	 * Spy is used because i want to mock some methods inside the Order I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the Order
	 * controller
	 */
	@Spy
	@InjectMocks
	private OrderController OrderController;


	/**
	 * Create Test
	 */
	@Test
	public void createTest() {

		String order_id = "1";
		String quantity = "11";
		String orderline_price = "11";
		String item_id = "1";

		Mockito.doReturn(order_id, item_id, quantity, orderline_price).when(OrderController).getInput();
		Order Order = new Order(1L, 2L, 1, 12.0);
		Order savedOrder = new Order(1L, 2L, 1, 12.0);
		Mockito.when(OrderServices.create(Order)).thenReturn(savedOrder);
		assertEquals(savedOrder, OrderController.create());
	}

	/**
	 * Update Test
	 */
	@Test
	public void updateTest() {
		String order_id = "1";
		String quantity = "11";
		String orderline_price = "11";
		String item_id = "1";
		Mockito.doReturn(order_id, item_id, quantity, orderline_price).when(OrderController).getInput();
		Order Order = new Order(1L, 2L, 1, 12.0);
		Mockito.when(OrderServices.update(Order)).thenReturn(Order);
		assertEquals(Order, OrderController.update());
	}


	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		String item_id = "1";
		Mockito.doReturn(item_id).when(OrderController).getInput();
		OrderController.delete();
		Mockito.verify(OrderServices, Mockito.times(1)).delete(1L);
	}

	/**
	 * ReadAllTest
	 */
	@Test
	public void readAllTest() {
		OrderController OrderController = new OrderController(OrderServices, null);
		List<Order> Orders = new ArrayList<>();
		Orders.add(new Order(1L, 2L, 1, 12.0));
		Orders.add(new Order(1L, 2L, 1, 12.0));
		Orders.add(new Order(1L, 2L, 1, 12.0));
		Mockito.when(OrderServices.readAll()).thenReturn(Orders);
		assertEquals(Orders, OrderController.readAll());
	}
}
