package com.qa.ims.persistence.dao;

import java.util.List;

public interface Dao<T> {

    List<T> readAll();
    
    T addtoOrderline(T t);
     
    T create(T t);
     
    T update(T t);
    
    T updateOrderline(T t);
    
    T calculateOrder(Long order_id1);
     
    void delete(long id);

	/**
	 * Deletes a Order in the database
	 * 
	 * @param order_id - order_id of the Order
	 */
	void deleteOrder(long order_id);
}
	