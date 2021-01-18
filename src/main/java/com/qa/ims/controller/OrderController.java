package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDaoMysql;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.services.OrderServices;
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
		Order order = new Order(customer_id);
		order = orderServices.create(order);
		
		
		
		List<Item> items = itemServices.readAll();
		Item item = null;
		LOGGER.info("Would you like to add an order to this item");
		Boolean loopy = false;
		String tnp = "";

			
			while (!loopy) {
				LOGGER.info("Please enter ITEM ID");
				Long item_id = Long.valueOf(getInput());
				LOGGER.info("Please enter the Quantity of the ITEM that you'd like");
				Integer quantity = Integer.valueOf(getInput());
				

				for(Item i : items) {
					if(i.getItem_id() == item_id) {
						item = i;
						break;
					}
				}


				LOGGER.info("----------------------------------------------");


				order.setItem(item);
				order.setQuantity(quantity);
				order = orderServices.additems(order);
				LOGGER.info("ARE U DONE N OR Y ");
				tnp = getInput().toLowerCase();
				if (tnp.contentEquals("y")) {
					loopy = true;
				}
				
			}
			LOGGER.info("Done");
			return order;
			
		}
	

		
	
		
		//Order Orderline = orderServices.(new Order(Order.getOrder_id(), 1L, 1));

		//od.addtoOrderline(1L, 1L, 0);	
		// item from list and add to orderline 
			//while loop start	

		// SELECT THE ITEM YOU WANT TO ADD TO THE LIST
		
			//
			//Item Item = itemServices.update(new orderline(item_id, item_id, item_price));
			// HOW MANY OF THIS ITEM DO YOU WANT ----> STORE IN QUANTITY WITH CURRENT
			// ORDERLINE_ID

			// DO YOUU WANT TO ADD ANOTHER ITEM

			// IF NO, CREATE ORDER, STORE INFORAMTION IN ORDERLINE,

			// DO A COUNT ON ITEM ID WHERE CURRENT GET_ORDER_ID IS = THIS IS WHERE WE STORE
			// THE QUANTITY
	
	


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
