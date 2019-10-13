package com.tem.springbootcrudrest.model;

import java.io.Serializable;

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
@Table(name = "vendorpayment")
@EntityListeners(AuditingEntityListener.class)
public class Vendorpayment implements Serializable {

	private static final long serialVersionUID = 441523520593693263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vendorpaymentid")
	private long vendorpaymentid;

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	@Column(name = "paymenttype")
	private String paymenttype;

	@Column(name = "amount")
	private double amount;

	@Column(name = "vendorreceiptdate")
	private String vendorreceiptdate; 

	@Column(name = "instrumentno")
	private String instrumentno;

	@Column(name = "instrumentdate")
	private String instrumentdate;
	
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "balanceamount")
	private String balanceamount;
	
	@Column(name = "vendorname")
	private String vendorname;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendpaymentid")
	private VendorPaymentParent vendorPaymentParent;

	public long getVendorpaymentid() {
		return vendorpaymentid;
	}

	public void setVendorpaymentid(long vendorpaymentid) {
		this.vendorpaymentid = vendorpaymentid;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getVendorreceiptdate() {
		return vendorreceiptdate;
	}

	public void setVendorreceiptdate(String vendorreceiptdate) {
		this.vendorreceiptdate = vendorreceiptdate;
	}

	public String getInstrumentno() {
		return instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		this.instrumentno = instrumentno;
	}

	public String getInstrumentdate() {
		return instrumentdate;
	}

	public void setInstrumentdate(String instrumentdate) {
		this.instrumentdate = instrumentdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getBalanceamount() {
		return balanceamount;
	}

	public void setBalanceamount(String balanceamount) {
		this.balanceamount = balanceamount;
	}

	public VendorPaymentParent getVendorPaymentParent() {
		return vendorPaymentParent;
	}

	public void setVendorPaymentParent(VendorPaymentParent vendorPaymentParent) {
		this.vendorPaymentParent = vendorPaymentParent;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}
	
}
