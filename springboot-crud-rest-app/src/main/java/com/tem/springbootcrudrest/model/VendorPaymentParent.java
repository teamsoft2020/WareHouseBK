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
@Table(name = "vendorpaymentparent")
@EntityListeners(AuditingEntityListener.class)
public class VendorPaymentParent implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vendpaymentid")
	private long vendpaymentid;

	@Column(name = "vendorreceiptdate")
	private String vendorreceiptdate;

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	@JsonManagedReference
	@OneToMany(mappedBy = "vendorPaymentParent", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vendorpayment> vendorpayment;

	public long getVendpaymentid() {
		return vendpaymentid;
	}

	public void setVendpaymentid(long vendpaymentid) {
		this.vendpaymentid = vendpaymentid;
	}

	public String getVendorreceiptdate() {
		return vendorreceiptdate;
	}

	public void setVendorreceiptdate(String vendorreceiptdate) {
		this.vendorreceiptdate = vendorreceiptdate;
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

	public List<Vendorpayment> getVendorpayment() {
		return vendorpayment;
	}

	public void setVendorpayment(List<Vendorpayment> vendorpayment) {
		this.vendorpayment = vendorpayment;
	}

}
