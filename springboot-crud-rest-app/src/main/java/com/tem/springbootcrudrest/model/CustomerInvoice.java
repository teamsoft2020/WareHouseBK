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
public class CustomerInvoice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 441523520593693263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customerinvoiceid")
	private long customerinvoiceid;

	@Column(name = "truckno")
	private String truckno;

	@Column(name = "trucktype")
	private String trucktype;

	@Column(name = "totaltrip")
	private String totaltrip;
	
	@Column(name = "totalcase")
	private String totalcase;

	@Column(name = "totalkmpercharge")
	private String totalkmpercharge;

	@Column(name = "totalfreightamt")
	private String totalfreightamt;

	@Column(name = "totaladvance")
	private String totaladvance;

	@Column(name = "totaldiscount")
	private String totaldiscount;

	@Column(name = "leakage")
	private String leakage;
	
	@Column(name = "netamount")
	private String netamount;

	@Column(name = "paymentstatus")
	private String paymentstatus;

	@Column(name = "receiptnumber")
	private String receiptnumber;

	@Column(name = "name")
	private String name;

	@Column(name = "totalkm")
	private String totalkm;

	@Column(name = "createddate")
	private String createddate;

	@Column(name = "modifieddate")
	private String modifieddate;

	public String getTotaltrip() {
		return totaltrip;
	}

	public void setTotaltrip(String totaltrip) {
		this.totaltrip = totaltrip;
	}

	public long getCustomerinvoiceid() {
		return customerinvoiceid;
	}

	public void setCustomerinvoiceid(long customerinvoiceid) {
		this.customerinvoiceid = customerinvoiceid;
	}

	public String getLeakage() {
		return leakage;
	}

	public void setLeakage(String leakage) {
		this.leakage = leakage;
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


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
