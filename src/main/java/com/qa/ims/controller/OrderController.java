package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

/**
 * Takes in Order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = Logger.getLogger(OrderController.class);

	private CrudServices<Order> orderServices;

	public OrderController(CrudServices<Order> OrderService) {
		this.orderServices = OrderService;
	}

	String getInput() {
		return Utils.getInput();
	}

	/**
	 * Reads all Orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> Orders = orderServices.readAll();
		for (Order Order : Orders) {
			LOGGER.info(Order.toString());
		}
		return Orders;
	}

	/**
	 * Creates a Order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the Order ID");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter customer ID");
		Long customer_id = Long.valueOf(getInput());
		Order Order = orderServices.create(new Order(order_id, customer_id));
		LOGGER.info("Order Created");
		return Order;
	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the Order ID");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter customer ID");
		Long customer_id = Long.valueOf(getInput());
		Order Order = orderServices.update(new Order(order_id, customer_id));
		LOGGER.info("Order Updated");
		return Order;
	}

	/**
	 * Deletes an existing Order by the id of the Order
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long Order_id = Long.valueOf(getInput());
		orderServices.delete(Order_id);
	}

}
