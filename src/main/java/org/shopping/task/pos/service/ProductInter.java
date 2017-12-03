package org.shopping.task.pos.service;

import java.util.List;

import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.model.Products;  

public interface ProductInter {

	public Products listAll(String bid);
	public List<Order> showOrder(Order order);
	
}
