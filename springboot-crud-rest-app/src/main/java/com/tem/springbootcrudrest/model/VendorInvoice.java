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
public class VendorInvoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vendorinvoiceid")
	private long vendorinvoiceid;

	@Column(name = "truckno")
	private String truckno;

	@Column(name = "trucktype")
	private String trucktype;

	@Column(name = "totalcase")
	private String totalcase;

	@Column(name = "totaltrip")
	private String totaltrip;

	@Column(name = "totalkmpercharge")
	private String totalkmpercharge;

	@Column(name = "totalfreightamt")
	private String totalfreightamt;

	@Column(name = "totaladvance")
	private String totaladvance;

	@Column(name = "totaldiscount")
	private String totaldiscount;

	@Column(name = "netamount")
	private String netamount;

	@Column(name = "paymentstatus")
	private String paymentstatus;

	@Column(name = "receiptnumber")
	private String receiptnumber;

	@Column(name = "vendorname")
	private String vendorname;
	
	@Column(name = "cancatload")
	private String cancatload;

	@Column(name = "totalkm")
	private String totalkm;

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	@Column(name = "paymenttype")
	private String paymenttype;

	@Column(name = "amount")
	private String amount;

	@Column(name = "paymentdate")
	private String paymentdate;

	@Column(name = "instrumentno")
	private String instrumentno;
	
	@Column(name = "vendpaymentid")
	private long vendpaymentid;
	
	@Column(name = "paymentmodifieddate")
	private String paymentmodifieddate;	
	
	@Column(name = "leakage")
	private String leakage;

	public long getVendorinvoiceid() {
		return vendorinvoiceid;
	}

	public void setVendorinvoiceid(long vendorinvoiceid) {
		this.vendorinvoiceid = vendorinvoiceid;
	}

	public String getTotaltrip() {
		return totaltrip;
	}

	public void setTotaltrip(String totaltrip) {
		this.totaltrip = totaltrip;
	}

	public String getTruckno() {
		return truckno;
	}

	public void setTruckno(String truckno) {
		this.truckno = truckno;
	}

	public String getTrucktype() {
		return trucktype;
	}

	public void setTrucktype(String trucktype) {
		this.trucktype = trucktype;
	}

	public String getTotalcase() {
		return totalcase;
	}

	public void setTotalcase(String totalcase) {
		this.totalcase = totalcase;
	}

	public String getCancatload() {
		return cancatload;
	}

	public void setCancatload(String cancatload) {
		this.cancatload = cancatload;
	}

	public String getTotalkmpercharge() {
		return totalkmpercharge;
	}

	public void setTotalkmpercharge(String totalkmpercharge) {
		this.totalkmpercharge = totalkmpercharge;
	}

	public String getTotalfreightamt() {
		return totalfreightamt;
	}

	public void setTotalfreightamt(String totalfreightamt) {
		this.totalfreightamt = totalfreightamt;
	}

	public String getTotaladvance() {
		return totaladvance;
	}

	public void setTotaladvance(String totaladvance) {
		this.totaladvance = totaladvance;
	}

	public String getTotaldiscount() {
		return totaldiscount;
	}

	public void setTotaldiscount(String totaldiscount) {
		this.totaldiscount = totaldiscount;
	}

	public String getNetamount() {
		return netamount;
	}

	public void setNetamount(String netamount) {
		this.netamount = netamount;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public String getReceiptnumber() {
		return receiptnumber;
	}

	public void setReceiptnumber(String receiptnumber) {
		this.receiptnumber = receiptnumber;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getTotalkm() {
		return totalkm;
	}

	public void setTotalkm(String totalkm) {
		this.totalkm = totalkm;
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

	public String getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getInstrumentno() {
		return instrumentno;
	}

	public void setInstrumentno(String instrumentno) {
		this.instrumentno = instrumentno;
	}

	public long getVendpaymentid() {
		return vendpaymentid;
	}

	public void setVendpaymentid(long vendpaymentid) {
		this.vendpaymentid = vendpaymentid;
	}

	public String getPaymentmodifieddate() {
		return paymentmodifieddate;
	}

	public void setPaymentmodifieddate(String paymentmodifieddate) {
		this.paymentmodifieddate = paymentmodifieddate;
	}

	public String getLeakage() {
		return leakage;
	}

	public void setLeakage(String leakage) {
		this.leakage = leakage;
	}
	
	
}
