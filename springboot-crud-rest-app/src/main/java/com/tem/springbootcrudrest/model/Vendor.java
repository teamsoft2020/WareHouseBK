package com.tem.springbootcrudrest.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vendor")
@EntityListeners(AuditingEntityListener.class)
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "vendorid", nullable = false)
	private long vendorid;
	
	@Column(name = "vendorcode", nullable = false)
	private String vendorcode;
	
	@Column(name = "vendorname", nullable = false)
	private String vendorname;
	
	@Column(name = "pan", nullable = true)
	private String PAN;
	
	@Column(name = "tan", nullable = true)
	private String TAN;
	
	@Column(name = "kyc", nullable = true)
	private String KYC;
	
	@Column(name = "iec", nullable = true)
	private String IEC;
	
	
	
	@Column(name = "bankname", nullable = true)
	private String bankName;
	
	@Column(name = "branch", nullable = true)
	private String branch;
	
	@Column(name = "accountno", nullable = true)
	private String accountNo;
	
	@Column(name = "ifsc", nullable = true)
	private String ifsc;
	
	@Column(name = "contactperson", nullable = true)
	private String contactPerson;
	
	@Column(name = "contactno", nullable = true)
	private String contactNo;
	
	/*@Temporal(TemporalType.DATE)
	@Column(name = "createddate", nullable = true)
	private Date createddate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "modifieddate", nullable = true)
	private Date modifieddate;*/
	
	@Column(name = "createddate")
	private String createddate;
	
	@Column(name = "modifieddate")
	private String modifiedDate;
	
	@Column(name = "Createdby", nullable = true)
	private String createdby;

	@JsonManagedReference
	@OneToMany(mappedBy = "vendorandvendoraddress", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VendorAddress> vendorAddress;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "vendorandvehicle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehicle> vendorvehicle;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendorcode() {
		return vendorcode;
	}

	public void setVendorcode(String vendorcode) {
		this.vendorcode = vendorcode;
	}
	
	public long getVendorid() {
		return vendorid;
	}

	public void setVendorid(long vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorname() {
		return vendorname;
	}

	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getTAN() {
		return TAN;
	}

	public void setTAN(String tAN) {
		TAN = tAN;
	}

	public String getKYC() {
		return KYC;
	}

	public void setKYC(String kYC) {
		KYC = kYC;
	}

	public String getIEC() {
		return IEC;
	}

	public void setIEC(String iEC) {
		IEC = iEC;
	}

	/*public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}*/

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public List<VendorAddress> getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(List<VendorAddress> vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<Vehicle> getVendorvehicle() {
		return vendorvehicle;
	}

	public void setVendorvehicle(List<Vehicle> vendorvehicle) {
		this.vendorvehicle = vendorvehicle;
	}
	
}
