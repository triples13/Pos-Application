package org.shopping.task.pos.service;

import java.util.List;

import org.shopping.task.pos.dao.ProductRepositoryImpl;
import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements ProductInter {

@Autowired
ProductRepositoryImpl userDao;
	public Products listAll(String bid) {
		
		return userDao.getProducts(bid);
	}
	public List<Order> showOrder(Order order) {
		// TODO Auto-generated method stub
		return userDao.showOrder(order);
	}
	

}
