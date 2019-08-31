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

	@Column(name = "loadNo")
	private String loadNo;

	@Column(name = "tripNo")
	private String tripNo;

	@Column(name = "origin")
	private String origin;

	@Column(name = "destination")
	private String destination;

	@Column(name = "invoiceNO")
	private String invoiceNO;

	@Column(name = "dateTime")
	private String dateTime;

	@Column(name = "truckType")
	private String truckType;

	@Column(name = "truckNo")
	private String truckNo;

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

	@Column(name = "perKMchargeCustomer")
	private String perKMchargeCustomer;

	@Column(name = "perKMchargeVendor")
	private String perKMchargeVendor;

	@Column(name = "profit")
	private String profit;

	@Column(name = "tollBill")
	private String tollBill;

	@Column(name = "policeBill")
	private String policeBill;

	@Column(name = "freightAmt")
	private String freightAmt;

	@Column(name = "haltingCharge")
	private String haltingCharge;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "updatedatetime")
	private String updateDateTime;
	
	@Column(name = "status")
	private String status;

	public long getTripid() {
		return tripid;
	}

	public void setTripid(long tripid) {
		this.tripid = tripid;
	}

	public String getLoadNo() {
		return loadNo;
	}

	public void setLoadNo(String loadNo) {
		this.loadNo = loadNo;
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

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
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

	public String getPerKMchargeCustomer() {
		return perKMchargeCustomer;
	}

	public void setPerKMchargeCustomer(String perKMchargeCustomer) {
		this.perKMchargeCustomer = perKMchargeCustomer;
	}

	public String getPerKMchargeVendor() {
		return perKMchargeVendor;
	}

	public void setPerKMchargeVendor(String perKMchargeVendor) {
		this.perKMchargeVendor = perKMchargeVendor;
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

	public String getFreightAmt() {
		return freightAmt;
	}

	public void setFreightAmt(String freightAmt) {
		this.freightAmt = freightAmt;
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
}
