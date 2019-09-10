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
@Table(name = "customerinvoice")
@EntityListeners(AuditingEntityListener.class)
public class CustomerInvoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 441523520593693263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customerinvoiceid")
	private long customerinvoiceid;

	@Column(name = "vehicleno")
	private String vehicleno;

	@Column(name = "totalkm")
	private String totalkm;

	@Column(name = "trip")
	private String trip;
	
	@Column(name = "customername")
	private String customername;

	@Column(name = "tollbill")
	private String tollbill;

	@Column(name = "total")
	private String total;

	@Column(name = "leakagebreakage")
	private String leakagebreakage;

	@Column(name = "customerinvoicestatus")
	private String customerinvoicestatus;

	@Column(name = "invoiceno")
	private String invoiceno;
	
	@Column(name = "grandtotal")
	private String grandtotal;	

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	
	public long getCustomerinvoiceid() {
		return customerinvoiceid;
	}

	public void setCustomerinvoiceid(long customerinvoiceid) {
		this.customerinvoiceid = customerinvoiceid;
	}

	public String getVehicleno() {
		return vehicleno;
	}
	
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public void setVehicleno(String vehicleno) {
		this.vehicleno = vehicleno;
	}

	public String getTotalkm() {
		return totalkm;
	}

	public void setTotalkm(String totalkm) {
		this.totalkm = totalkm;
	}

	public String getTrip() {
		return trip;
	}

	public void setTrip(String trip) {
		this.trip = trip;
	}

	public String getTollbill() {
		return tollbill;
	}

	public void setTollbill(String tollbill) {
		this.tollbill = tollbill;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getLeakagebreakage() {
		return leakagebreakage;
	}

	public void setLeakagebreakage(String leakagebreakage) {
		this.leakagebreakage = leakagebreakage;
	}

	public String getCustomerinvoicestatus() {
		return customerinvoicestatus;
	}

	public void setCustomerinvoicestatus(String customerinvoicestatus) {
		this.customerinvoicestatus = customerinvoicestatus;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}
	
	public String getGrandtotal() {
		return grandtotal;
	}

	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
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
