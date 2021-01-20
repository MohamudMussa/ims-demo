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
		
		LOGGER.info("VIEW - to view all orders");
		LOGGER.info("CAL - to to calculate an order");
		String read = String.valueOf(getInput().toLowerCase());

		switch (read) {
		case "cal":
			Long order_id = Long.valueOf(getInput());
			List<Order> Orders = orderServices.readAll();
			for (Order Order : Orders) {
				if (Order.getOrder_id() == order_id) {
					Orders = i;
					LOGGER.info("You have added" + " " + quantity + " " + "of the below Item");
					System.out.println(i);
					break;
				}
				LOGGER.info(Order.toString());
			}
			return Orders;
			

		default:
			
			List<Order> Orders1 = orderServices.readAll();
			for (Order Order : Orders1) {
				LOGGER.info(Order.toString());
			}
			return Orders1;
		
		}
		
	
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
		LOGGER.info("This is your Order ID " + " " + order.getOrder_id());
		LOGGER.info("Please make a not of it");
		List<Item> items = itemServices.readAll();
		Item item = null;
		Boolean loopy = false;
		String tnp = "";

		while (!loopy) {
			LOGGER.info("please re enter your order_id");
			Long order_id = Long.valueOf(getInput());
			
			LOGGER.info("Please enter ITEM ID");
			Long item_id = Long.valueOf(getInput());
			
			LOGGER.info("Please enter the Quantity of the ITEM that you'd like");
			Integer quantity = Integer.valueOf(getInput());

			for (Item i : items) {
				if (i.getItem_id() == item_id) {
					item = i;
					LOGGER.info("You have added" + " " + quantity + " " + "of the below Item");
					System.out.println(i);
					break;
				}
			}
			order.setOrder_id(order_id);
			order.setItem(item);
			int final_price = (int) (item.getItem_price() * quantity);
			order.setQuantity(quantity);
			order.setOrderline_price(final_price);
			order = orderServices.additems(order);
			LOGGER.info("ADD: To add another Item to the order ");
			LOGGER.info("RETURN: TO EXIT ");
			tnp = getInput().toLowerCase();
			if (tnp.contentEquals("return")) {
				loopy = true;
			}

		}
		LOGGER.info("Done");
		return order;

	}


	// IF NO, CREATE ORDER, STORE INFORAMTION IN ORDERLINE,

	// DO A COUNT ON ITEM ID WHERE CURRENT GET_ORDER_ID IS = THIS IS WHERE WE STORE
	// THE QUANTITY

	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {

		LOGGER.info("ADD - to add an ITEM to an exisiting order");
		LOGGER.info("UPDATE - to assign another customer to an exisiting order ");
		List<Order> orders = orderServices.readAll(); 
	
		
		List<Item> items = itemServices.readAll();
		Item item = null;
		
		String selectoption1 = String.valueOf(getInput().toLowerCase());

		switch (selectoption1) {
		
		case "add":


			LOGGER.info("Please enter the Order ID thay you'd like to update");
			Long order_id1 = Long.valueOf(getInput());

			for (Order i : orders) {
				Order order = null;
				while (i.getOrder_id() == order_id1) {
					order = i;
					System.out.println(i);
					break;
				}
			}
			
			LOGGER.info("Please enter the new ITEM ID you'd like to connect to this order");
			Long item_id1 = Long.valueOf(getInput());

			for (Item i : items) {
				if (i.getItem_id() == item_id1) {
					item = i;
					System.out.println(i);
					break;
				}
			}
			
			
			Order Order1 = orderServices.update(new Order(order_id1, item_id1));
			LOGGER.info("Order Updated");
			return Order1;

		case "update":
			
	
			LOGGER.info("Please enter the Order ID thay you'd like to update");
			Long order_id = Long.valueOf(getInput());

			for (Order i : orders) {
				Order order = null;
				while (i.getOrder_id() == order_id) {
					order = i;
					System.out.println(i);
					break;
				}
			}

			LOGGER.info("Please enter the new customer ID you'd like to connect to this order");
			Long customer_id = Long.valueOf(getInput());
			Order Order = orderServices.update(new Order(order_id, customer_id));
			LOGGER.info("Order Updated");
			return Order;

		default:
			LOGGER.info("enter valid info");
			break;
		}

		return null;


	}

	/**
	 * Deletes an existing Order by the id of the Order
	 */
	@Override
	public void delete() {

		LOGGER.info("Would you like to delete and ITEM from an order or Delete a entier ORDER");
		String select = String.valueOf(getInput().toLowerCase());

		switch (select) {
		case "item":

			LOGGER.info("Please enter the id of the Order you would like to delete an item from");
			Long Order_id = Long.valueOf(getInput());
			List<Order> orders = orderServices.readAll();

			for (Order i : orders) {
				Order order = null;
				while (i.getOrder_id() == Order_id) {
					order = i;
					System.out.println(i);
					break;
				}
			}
			LOGGER.info("SELECT ITEM FROM ORDER BY CHOOSING THE CORRECT ORDERLINE_ID");
			Long orderline_id = Long.valueOf(getInput());

			LOGGER.info("Item has been Deleted");
			orderServices.delete(orderline_id);

			break;

		case "order":
			List<Order> orders1 = orderServices.readAll();
			LOGGER.info("Please enter the id of the Order you would like to delete");
			Long Order_id1 = Long.valueOf(getInput());

			for (Order i : orders1) {
				Order order = null;
				while (i.getOrder_id() == Order_id1) {
					order = i;
					System.out.println(i);
					break;
				}
			}

			LOGGER.info("These orders have been Deleted");
			orderServices.deleteOrder(Order_id1);

			break;

		default:

			break;
		}

	}

}
