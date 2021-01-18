package com.qa.ims.persistence.dao;

import java.util.List;

public interface Dao<T> {

    List<T> readAll();
    
    T addtoOrderline(T t);
     
    T create(T t);
     
    T update(T t);
     
    void delete(long id);
}
	