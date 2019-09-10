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
@Table(name = "vendorinvoice")
@EntityListeners(AuditingEntityListener.class)
public class VendorInvoice implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vindorinvoiceid")
	private long vindorinvoiceid;

	@Column(name = "vehicleno")
	private String vehicleno;

	@Column(name = "totalkm")
	private String totalkm;

	@Column(name = "trip")
	private String trip;

	@Column(name = "tollbill")
	private String tollbill;

	@Column(name = "total")
	private String total;

	@Column(name = "leakagebreakage")
	private String leakagebreakage;

	@Column(name = "customerinvoicestatus")
	private String vendorinvoicestatus;

	@Column(name = "invoiceno")
	private String invoiceno;
	
	@Column(name = "vendorname")
	private String vendorname;
	
	@Column(name = "grandtotal")
	private String grandtotal;	

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	public long getVindorinvoiceid() {
		return vindorinvoiceid;
	}

	public void setVindorinvoiceid(long vindorinvoiceid) {
		this.vindorinvoiceid = vindorinvoiceid;
	}

	public String getVehicleno() {
		return vehicleno;
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

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
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

	public String getVendorinvoicestatus() {
		return vendorinvoicestatus;
	}

	public void setVendorinvoicestatus(String vendorinvoicestatus) {
		this.vendorinvoicestatus = vendorinvoicestatus;
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
