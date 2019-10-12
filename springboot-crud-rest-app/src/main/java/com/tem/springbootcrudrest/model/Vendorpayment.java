package com.tem.springbootcrudrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
	private String amount;

	@Column(name = "vendorreceiptdate")
	private String vendorreceiptdate;

	@Column(name = "instrumentno")
	private String instrumentno;

	@Column(name = "instrumentdate")
	private String instrumentdate;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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
}
