package org.shopping.task.pos.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.shopping.task.pos.model.Order;
import org.shopping.task.pos.model.Products;
import org.springframework.transaction.annotation.Transactional;


public class ProductRepositoryImpl implements ProductRepository{

	final static Logger logger=Logger.getLogger(ProductRepositoryImpl.class);
	private SessionFactory sessionFactory;
	
	public ProductRepositoryImpl(SessionFactory factory){
		this.sessionFactory=factory;
	}
	@Transactional
	public Products getProducts(String id) {
		
		Products product=(Products) sessionFactory.getCurrentSession().createQuery("from Products where barcode_id="+id).uniqueResult();
		return product;
		
	}
/*@Transactional
	public void saveOrders(String barcode)
	{
		
		Products product=getProducts(barcode);
		Order orders=(Order) sessionFactory.getCurrentSession().createQuery("from Order where barcodeid="+barcode).uniqueResult();
		if(orders!=null && orders.getBarcodeid().equals(barcode))
		{
			int count=orders.getQty();
			count++;
			sessionFactory.getCurrentSession().
			createQuery("update Order set price=:orderprice,qty=:newqty where barcodeid="+barcode).
			setParameter("orderprice", product.getPrice()*count).setParameter("newqty", count).
			executeUpdate();
			
		}
		if(orders==null){
		Order order=new Order();
		order.setPname(product.getProduct_name());
		order.setPrice(product.getPrice());
		order.setBarcodeid(product.getBarcode_id());
		order.setQty(1);
		sessionFactory.getCurrentSession().save(order);
	     }
	}
	
	@Transactional
	public List<Order> getOrders(String barcode){
		saveOrders(barcode);
		List<Order> orders=sessionFactory.getCurrentSession().createQuery("from Order").list();
		System.out.println("inside getorder method");
		System.out.println(orders);
		return orders;
	}
	*/
	@Transactional
	public void addorUpdateOrder(Order order) {
	
		Order orderInDb=(Order) sessionFactory.getCurrentSession().createQuery("from Order where barcodeid=:barcode").setParameter("barcode", order.getBarcodeid()).uniqueResult();
		if(orderInDb==null){
			logger.info("error while saving");
			sessionFactory.getCurrentSession().save(order);
			logger.warn("error while saving Order");
		}
		else{
			int count=orderInDb.getQty();
			count++;
			Products product=getProducts(order.getBarcodeid());
			sessionFactory.getCurrentSession().
			createQuery("update Order set price=:orderprice,qty=:newqty where barcodeid="+orderInDb.getBarcodeid()).
			setParameter("orderprice", product.getPrice()*count).setParameter("newqty", count).executeUpdate();
		}
		
		
	}
	
	@Transactional
	public List<Order> showOrder(Order order){
		addorUpdateOrder(order);
		List<Order> orderFromDb= sessionFactory.getCurrentSession().createQuery("from Order").list();
		return orderFromDb;
	}
	
}