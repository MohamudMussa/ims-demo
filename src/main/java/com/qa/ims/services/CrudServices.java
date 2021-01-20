package com.qa.ims.services;

import java.util.List;

public interface CrudServices<T> {

    public List<T> readAll();
    
    T additems(T t);
     
    T create(T t);
     
    T update(T t);
    
    T updateOrderline(T t);
    

 
    void delete(Long id);

	public void deleteOrder(Long order_id1);

	public void calculateOrder(Long order_id1);
	


}
