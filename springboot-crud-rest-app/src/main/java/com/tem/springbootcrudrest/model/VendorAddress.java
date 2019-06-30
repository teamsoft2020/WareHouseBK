package com.tem.springbootcrudrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vendoraddress")
@EntityListeners(AuditingEntityListener.class)
public class VendorAddress {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long vendoraddrid;
	
	@Column(name = "vendoraddr")
	private String vendoraddr;
	
	@Column(name = "mobileno")
	private String mobileno;
	
	@Column(name = "phoneno")
	private String phoneno;
	
	@Column(name = "gstin")
	private String gstin;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private Vendor vendorandvendoraddress;

	
	public long getVendoraddrid() {
		return vendoraddrid;
	}

	public void setVendoraddrid(long vendoraddrid) {
		this.vendoraddrid = vendoraddrid;
	}

	public String getVendoraddr() {
		return vendoraddr;
	}

	public void setVendoraddr(String vendoraddr) {
		this.vendoraddr = vendoraddr;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public Vendor getVendorandvendoraddress() {
		return vendorandvendoraddress;
	}

	public void setVendorandvendoraddress(Vendor vendorandvendoraddress) {
		this.vendorandvendoraddress = vendorandvendoraddress;
	}
	
}
