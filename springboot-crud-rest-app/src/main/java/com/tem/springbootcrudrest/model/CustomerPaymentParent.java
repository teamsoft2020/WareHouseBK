package com.tem.springbootcrudrest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customerpaymentparent")
@EntityListeners(AuditingEntityListener.class)
public class CustomerPaymentParent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "cuspaymentid")
	private long cuspaymentid;

	@Column(name = "customerreceiptdate")
	private String customerreceiptdate;

	@JsonManagedReference
	@OneToMany(mappedBy = "customerPaymentParent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Customerpayment> customerpayment;
	
	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;
	

	public long getCuspaymentid() {
		return cuspaymentid;
	}

	public void setCuspaymentid(long cuspaymentid) {
		this.cuspaymentid = cuspaymentid;
	}

	public List<Customerpayment> getCustomerpayment() {
		return customerpayment;
	}

	public void setCustomerpayment(List<Customerpayment> customerpayment) {
		this.customerpayment = customerpayment;
	}

	public String getCustomerreceiptdate() {
		return customerreceiptdate;
	}

	public void setCustomerreceiptdate(String customerreceiptdate) {
		this.customerreceiptdate = customerreceiptdate;
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
}
