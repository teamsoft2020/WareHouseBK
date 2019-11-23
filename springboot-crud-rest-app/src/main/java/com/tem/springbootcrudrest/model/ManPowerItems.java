package com.tem.springbootcrudrest.model;

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
@Table(name = "manpoweritems")
@EntityListeners(AuditingEntityListener.class)
public class ManPowerItems {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "manpoweritemid")
	private Long manpoweritemid;
	
	@Column(name = "cgst")
	private String cgst;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "hsn")
	private String hsn;
	
	@Column(name = "igst")
	private String igst;
	
	@Column(name = "item")
	private String item;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "sgst")
	private String sgst;
	
	@Column(name = "taxpercentage")
	private String taxpercentage;
	
	@Column(name = "total")
	private String total;
	
	@Column(name = "unitprice")
	private String unitprice;
	
	@Column(name = "withoutTax")
	private String withoutTax;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "manpowerid")
	private ManPower customerstateDetails;

	public Long getManpoweritemid() {
		return manpoweritemid;
	}

	public String getCgst() {
		return cgst;
	}

	public String getDescription() {
		return description;
	}

	public String getHsn() {
		return hsn;
	}

	public String getIgst() {
		return igst;
	}

	public String getItem() {
		return item;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getSgst() {
		return sgst;
	}

	public String getTaxpercentage() {
		return taxpercentage;
	}

	public String getTotal() {
		return total;
	}

	public String getUnitprice() {
		return unitprice;
	}

	public String getWithoutTax() {
		return withoutTax;
	}

	public ManPower getCustomerstateDetails() {
		return customerstateDetails;
	}

	public void setManpoweritemid(Long manpoweritemid) {
		this.manpoweritemid = manpoweritemid;
	}

	public void setCgst(String cgst) {
		this.cgst = cgst;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	public void setIgst(String igst) {
		this.igst = igst;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setSgst(String sgst) {
		this.sgst = sgst;
	}

	public void setTaxpercentage(String taxpercentage) {
		this.taxpercentage = taxpercentage;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public void setUnitprice(String unitprice) {
		this.unitprice = unitprice;
	}

	public void setWithoutTax(String withoutTax) {
		this.withoutTax = withoutTax;
	}

	public void setCustomerstateDetails(ManPower customerstateDetails) {
		this.customerstateDetails = customerstateDetails;
	}
	
}
