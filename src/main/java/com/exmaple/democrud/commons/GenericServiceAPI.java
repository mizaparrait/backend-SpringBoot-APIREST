package com.exmaple.democrud.commons;

import java.io.Serializable;
import java.util.*;

public interface GenericServiceAPI<T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID id);
	
	T get(ID id);
	
	List<T> getAll();
}
