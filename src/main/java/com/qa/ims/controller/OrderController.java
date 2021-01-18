package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Item;
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
	private CrudServices<Item> itemServices;

	public OrderController(CrudServices<Order> orderServices, CrudServices<Item> itemServices) {
		this.orderServices = orderServices;
		this.itemServices = itemServices;
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
		LOGGER.info("Please enter the Customer ID");
		Long customer_id = Long.valueOf(getInput());
		Order Order = orderServices.create(new Order(customer_id));
		LOGGER.info("Order Created" + " " + "here is the Order_ID:" + " " + Order.getOrder_id());

		// SHOW THEM A LIST OF ITEMS VIA ITEM_ID


		LOGGER.info("Please select one of the following Items below");
		LOGGER.info("----------------------------------------------");
		
		
		//fix
		List<Item> Items = itemServices.readAll();
		for (Item item : Items) {
			LOGGER.info(item.toString());
		
			


		// SELECT THE ITEM YOU WANT TO ADD TO THE LIST
			//LOGGER.info("Please enter the id of the Item you would like to update");
			//Long item_id = Long.valueOf(getInput());	
			//Item Item = itemServices.update(new orderline(item_id, item_id, item_price));
			// HOW MANY OF THIS ITEM DO YOU WANT ----> STORE IN QUANTITY WITH CURRENT
			// ORDERLINE_ID

			// DO YOUU WANT TO ADD ANOTHER ITEM

			// IF NO, CREATE ORDER, STORE INFORAMTION IN ORDERLINE,

			// DO A COUNT ON ITEM ID WHERE CURRENT GET_ORDER_ID IS = THIS IS WHERE WE STORE
			// THE QUANTITY
		}
		return Order;
	}

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the Order ID thay you'd like toupdate");
		Long order_id = Long.valueOf(getInput());
		LOGGER.info("Please enter the new customer ID you'd like to connect to this order");
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
		LOGGER.info("Order Deleted");
		orderServices.delete(Order_id);
	}

}
