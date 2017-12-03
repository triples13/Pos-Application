package org.shopping.task.pos.dao;

import java.util.List;

import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.model.Products;

public interface ProductRepository {

	public Products getProducts(String bid);
	/*public void saveOrders(String barcode);
	public List<Order> getOrders(String barcode);*/
	public void addorUpdateOrder(Order order);
	public List<Order> showOrder(Order order);
}
