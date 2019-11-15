package com.tem.springbootcrudrest.staticdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ManpowerInvoiceStaticFeild {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;
	private String itemname;
	private String taxpercentage;
	private String hsncode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getTaxpercentage() {
		return taxpercentage;
	}
	public void setTaxpercentage(String taxpercentage) {
		this.taxpercentage = taxpercentage;
	}
	public String getHsncode() {
		return hsncode;
	}
	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}	
	
}
