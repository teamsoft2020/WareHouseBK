package com.tem.springbootcrudrest.staticdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TruckRate {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;
	
	private String trucktype;
	private String customerrate;
	private String vendorrate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTrucktype() {
		return trucktype;
	}
	public void setTrucktype(String trucktype) {
		this.trucktype = trucktype;
	}
	public String getCustomerrate() {
		return customerrate;
	}
	public void setCustomerrate(String customerrate) {
		this.customerrate = customerrate;
	}
	public String getVendorrate() {
		return vendorrate;
	}
	public void setVendorrate(String vendorrate) {
		this.vendorrate = vendorrate;
	}
	
}
