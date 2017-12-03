package org.shopping.task.pos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {

	@Id
	@GeneratedValue
	private int oid;
	private String pname;

	private int qty;
	private double price;
	private String barcodeid;
	
	public int getOid() {
		return oid;
	}
	public String getBarcodeid() {
		return barcodeid;
	}
	public void setBarcodeid(String barcodeid) {
		this.barcodeid = barcodeid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
