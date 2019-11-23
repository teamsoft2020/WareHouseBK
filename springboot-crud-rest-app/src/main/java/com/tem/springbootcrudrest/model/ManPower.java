package com.tem.springbootcrudrest.model;

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
@Table(name = "manpower")
@EntityListeners(AuditingEntityListener.class)
public class ManPower {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "manpowerid")
	private Long manpowerid;
	
	@Column(name = "customerbranch")
	private String customerbranch;
	
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "customerstate")
	private String customerstate;
	
	@Column(name = "grandTotal")
	private String grandTotal;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "customerstateDetails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ManPowerItems> itemDetails;

	public Long getManpowerid() {
		return manpowerid;
	}

	public void setManpowerid(Long manpowerid) {
		this.manpowerid = manpowerid;
	}

	public String getCustomerbranch() {
		return customerbranch;
	}

	public void setCustomerbranch(String customerbranch) {
		this.customerbranch = customerbranch;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerstate() {
		return customerstate;
	}

	public void setCustomerstate(String customerstate) {
		this.customerstate = customerstate;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public List<ManPowerItems> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(List<ManPowerItems> itemDetails) {
		this.itemDetails = itemDetails;
	}
}
