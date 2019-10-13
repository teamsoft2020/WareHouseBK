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
@Table(name = "customerpayment")
@EntityListeners(AuditingEntityListener.class)
public class Customerpayment implements Serializable {

	private static final long serialVersionUID = 441523520593693263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "childcustomerpaymentid")
	private long childcustomerpaymentid;

	@Column(name = "paymenttype")
	private String paymenttype;

	@Column(name = "amount")
	private String amount;

	@Column(name = "instrumentno")
	private String instrumentno;

	@Column(name = "instrumentdate")
	private String instrumentdate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "balanceamount")
	private String balanceamount;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cuspaymentid")
	private CustomerPaymentParent customerPaymentParent;

	public long getChildcustomerpaymentid() {
		return childcustomerpaymentid;
	}

	public void setChildcustomerpaymentid(long childcustomerpaymentid) {
		this.childcustomerpaymentid = childcustomerpaymentid;
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

	public String getInstrumentdate() {
		return instrumentdate;
	}

	public void setInstrumentdate(String instrumentdate) {
		this.instrumentdate = instrumentdate;
	}

	public CustomerPaymentParent getCustomerPaymentParent() {
		return customerPaymentParent;
	}

	public void setCustomerPaymentParent(CustomerPaymentParent customerPaymentParent) {
		this.customerPaymentParent = customerPaymentParent;
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
}
