package org.shopping.task.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue
	private int pid;
	public int getPid() {
		return pid;
	}
	private String barcode_id;
	private String product_name;
	private double price;
	public String getBarcode_id() {
		return barcode_id;
	}
	public void setBarcode_id(String barcode_id) {
		this.barcode_id = barcode_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
