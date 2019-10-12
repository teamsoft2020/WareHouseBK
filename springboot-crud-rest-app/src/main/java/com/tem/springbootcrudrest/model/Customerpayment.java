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
@Table(name = "customerpayment")
@EntityListeners(AuditingEntityListener.class)
public class Customerpayment implements Serializable {

	private static final long serialVersionUID = 441523520593693263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customerpaymentid")
	private long customerpaymentid;

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	@Column(name = "paymenttype")
	private String paymenttype;

	@Column(name = "amount")
	private String amount;

	@Column(name = "customerreceiptdate")
	private String customerreceiptdate;

	@Column(name = "instrumentno")
	private String instrumentno;
	
	@Column(name = "instrumentdate")
	private String instrumentdate;

	public long getCustomerpaymentid() {
		return customerpaymentid;
	}

	public void setCustomerpaymentid(long customerpaymentid) {
		this.customerpaymentid = customerpaymentid;
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

	public String getInstrumentno() {
		return instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		this.instrumentno = instrumentno;
	}

	public String getCustomerreceiptdate() {
		return customerreceiptdate;
	}

	public void setCustomerreceiptdate(String customerreceiptdate) {
		this.customerreceiptdate = customerreceiptdate;
	}

	public String getInstrumentdate() {
		return instrumentdate;
	}

	public void setInstrumentdate(String instrumentdate) {
		this.instrumentdate = instrumentdate;
	}
	
	
}
