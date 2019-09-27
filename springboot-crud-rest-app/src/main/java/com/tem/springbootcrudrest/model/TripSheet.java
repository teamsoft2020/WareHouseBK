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
@Table(name = "tripsheet")
@EntityListeners(AuditingEntityListener.class)
public class TripSheet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "tripid")
	private long tripid;

	@Column(name = "loadno")
	private String loadno;

	@Column(name = "tripNo")
	private String tripNo;

	@Column(name = "origin")
	private String origin;

	@Column(name = "destination")
	private String destination;

	@Column(name = "invoiceNO")
	private String invoiceNO;

	@Column(name = "datetime")
	private String datetime;

	@Column(name = "truckType")
	private String truckType;

	@Column(name = "truckno")
	private String truckno;

	@Column(name = "driverName")
	private String driverName;

	@Column(name = "noOfCase")
	private String noOfCase;

	@Column(name = "OPKM")
	private String OPKM;

	@Column(name = "CLSKM")
	private String CLSKM;

	@Column(name = "diffKM")
	private String diffKM;

	@Column(name = "advance")
	private String advance;

	@Column(name = "perkmchargecustomer")
	private String perkmchargecustomer;

	@Column(name = "perkmchargevendor")
	private String perkmchargevendor;

	@Column(name = "profit")
	private String profit;

	@Column(name = "tollBill")
	private String tollBill;

	@Column(name = "policeBill")
	private String policeBill;

	@Column(name = "freightAmtCust")
	private String freightAmtCust;

	@Column(name = "freightAmtVen")
	private String freightAmtVen;
	
	@Column(name = "haltingCharge")
	private String haltingCharge;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "updatedatetime")
	private String updateDateTime;

	@Column(name = "status")
	private String status;

	@Column(name = "username")
	private String username;

	@Column(name = "lastupdate")
	private String lastupdate;

	@Column(name = "customerinvoice")
	private String customerinvoice;

	@Column(name = "vendorinvoice")
	private String vendorinvoice;

	@Column(name = "paymentreceivedornot")
	private String paymentreceivedornot;

	@Column(name = "discount")
	private String discount;
	
	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public long getTripid() {
		return tripid;
	}

	public void setTripid(long tripid) {
		this.tripid = tripid;
	}

	

	public String getLoadno() {
		return loadno;
	}

	public void setLoadno(String loadno) {
		this.loadno = loadno;
	}

	public String getFreightAmtCust() {
		return freightAmtCust;
	}

	public void setFreightAmtCust(String freightAmtCust) {
		this.freightAmtCust = freightAmtCust;
	}

	public String getFreightAmtVen() {
		return freightAmtVen;
	}

	public void setFreightAmtVen(String freightAmtVen) {
		this.freightAmtVen = freightAmtVen;
	}

	public String getTripNo() {
		return tripNo;
	}

	public void setTripNo(String tripNo) {
		this.tripNo = tripNo;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getInvoiceNO() {
		return invoiceNO;
	}

	public void setInvoiceNO(String invoiceNO) {
		this.invoiceNO = invoiceNO;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getTruckno() {
		return truckno;
	}

	public void setTruckno(String truckno) {
		this.truckno = truckno;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getNoOfCase() {
		return noOfCase;
	}

	public void setNoOfCase(String noOfCase) {
		this.noOfCase = noOfCase;
	}

	public String getOPKM() {
		return OPKM;
	}

	public void setOPKM(String OPKM) {
		this.OPKM = OPKM;
	}

	public String getCLSKM() {
		return CLSKM;
	}

	public void setCLSKM(String CLSKM) {
		this.CLSKM = CLSKM;
	}

	public String getDiffKM() {
		return diffKM;
	}

	public void setDiffKM(String diffKM) {
		this.diffKM = diffKM;
	}

	public String getAdvance() {
		return advance;
	}

	public void setAdvance(String advance) {
		this.advance = advance;
	}

	public String getPerkmchargecustomer() {
		return perkmchargecustomer;
	}

	public void setPerkmchargecustomer(String perkmchargecustomer) {
		this.perkmchargecustomer = perkmchargecustomer;
	}

	public String getPerkmchargevendor() {
		return perkmchargevendor;
	}

	public void setPerkmchargevendor(String perkmchargevendor) {
		this.perkmchargevendor = perkmchargevendor;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public String getTollBill() {
		return tollBill;
	}

	public void setTollBill(String tollBill) {
		this.tollBill = tollBill;
	}

	public String getPoliceBill() {
		return policeBill;
	}

	public void setPoliceBill(String policeBill) {
		this.policeBill = policeBill;
	}

	public String getHaltingCharge() {
		return haltingCharge;
	}

	public void setHaltingCharge(String haltingCharge) {
		this.haltingCharge = haltingCharge;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}

	public String getCustomerinvoice() {
		return customerinvoice;
	}

	public void setCustomerinvoice(String customerinvoice) {
		this.customerinvoice = customerinvoice;
	}

	public String getVendorinvoice() {
		return vendorinvoice;
	}

	public void setVendorinvoice(String vendorinvoice) {
		this.vendorinvoice = vendorinvoice;
	}

	public String getPaymentreceivedornot() {
		return paymentreceivedornot;
	}

	public void setPaymentreceivedornot(String paymentreceivedornot) {
		this.paymentreceivedornot = paymentreceivedornot;
	}
}
