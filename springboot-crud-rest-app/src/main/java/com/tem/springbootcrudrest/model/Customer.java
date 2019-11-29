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
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;

	@Column(name = "Customer_Id")
	private long customerId;

	
	@Column(name = "customername")
	private String customername;

	@Column(name = "pan")
	private String PAN;

	@Column(name = "tan")
	private String TAN;

	@Column(name = "kyc")
	private String KYC;

	@Column(name = "iec")
	private String IEC;

	//@Temporal(TemporalType.DATE)
	@Column(name = "createddate")
	private String createddate;

	@Column(name = "Created_by")
	private String createdby;

	@Column(name = "fixedamttrs")
	private String fixedamttrs;
	@Column(name = "fixedamtlc2")
	private String fixedamtlc2;
	@Column(name = "fixedamtlc4")
	private String fixedamtlc4;
	@Column(name = "fixedamtcan6")
	private String fixedamtcan6;
	@Column(name = "fixedamthcv9")
	private String fixedamthcv9;
	@Column(name = "fixedamttrailer")
	private String fixedamttrailer;

	@Column(name = "perkmtrs")
	private String perkmtrs;
	@Column(name = "perkmlc2")
	private String perkmlc2;
	@Column(name = "perkmlc4")
	private String perkmlc4;

	@Column(name = "perkmcan6")
	private String perkmcan6;

	@Column(name = "perkmhcv9")
	private String perkmhcv9;
	@Column(name = "perkmtrailer")
	private String perkmtrailer;
	
	@Column(name = "bankName")
	private String bankName;
	@Column(name = "branch")
	private String branch;
	@Column(name = "accountNo")
	private String accountNo;
	@Column(name = "ifsc")
	private String ifsc;
	@Column(name = "contactPerson")
	private String contactPerson;
	@Column(name = "contactNo")
	private String contactNo;
	// @OneToMany(targetEntity=CustomerDetails.class,mappedBy =
	// "customer",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonManagedReference
	@OneToMany(mappedBy = "customeranddcustomeretails", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CustomerDetails> customerDetails;

	// public List<CustomerDetails> getCustomerDetails() {
	// return CustomerDetails;
	// }
	// public void setCustomerDetails(List<CustomerDetails> customerDetails) {
	// CustomerDetails = customerDetails;
	// }
	//
	public String getPerkmcan6() {
		return perkmcan6;
	}

	public void setPerkmcan6(String perkmcan6) {
		this.perkmcan6 = perkmcan6;
	}

	public String getPerkmhcv9() {
		return perkmhcv9;
	}

	public void setPerkmhcv9(String perkmhcv9) {
		this.perkmhcv9 = perkmhcv9;
	}

	public String getPerkmtrailer() {
		return perkmtrailer;
	}

	public void setPerkmtrailer(String perkmtrailer) {
		this.perkmtrailer = perkmtrailer;
	}

	public String getFixedamttrs() {
		return fixedamttrs;
	}

	public void setFixedamttrs(String fixedamttrs) {
		this.fixedamttrs = fixedamttrs;
	}

	public String getFixedamtlc2() {
		return fixedamtlc2;
	}

	public void setFixedamtlc2(String fixedamtlc2) {
		this.fixedamtlc2 = fixedamtlc2;
	}

	public String getFixedamtlc4() {
		return fixedamtlc4;
	}

	public void setFixedamtlc4(String fixedamtlc4) {
		this.fixedamtlc4 = fixedamtlc4;
	}

	public String getFixedamtcan6() {
		return fixedamtcan6;
	}

	public void setFixedamtcan6(String fixedamtcan6) {
		this.fixedamtcan6 = fixedamtcan6;
	}

	public String getFixedamthcv9() {
		return fixedamthcv9;
	}

	public void setFixedamthcv9(String fixedamthcv9) {
		this.fixedamthcv9 = fixedamthcv9;
	}

	public String getFixedamttrailer() {
		return fixedamttrailer;
	}

	public void setFixedamttrailer(String fixedamttrailer) {
		this.fixedamttrailer = fixedamttrailer;
	}

	public String getPerkmtrs() {
		return perkmtrs;
	}

	public void setPerkmtrs(String perkmtrs) {
		this.perkmtrs = perkmtrs;
	}

	public String getPerkmlc2() {
		return perkmlc2;
	}

	public void setPerkmlc2(String perkmlc2) {
		this.perkmlc2 = perkmlc2;
	}

	public String getPerkmlc4() {
		return perkmlc4;
	}

	public void setPerkmlc4(String perkmlc4) {
		this.perkmlc4 = perkmlc4;
	}

	public List<CustomerDetails> getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(List<CustomerDetails> customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
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

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
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

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO) public long getId() {
	 * return id; } public void setId(long id) { this.id = id; }
	 * 
	 * @Column(name = "first_name", nullable = false) public String
	 * getFirstName() { return firstName; } public void setFirstName(String
	 * firstName) { this.firstName = firstName; }
	 * 
	 * @Column(name = "last_name", nullable = false) public String getLastName()
	 * { return lastName; } public void setLastName(String lastName) {
	 * this.lastName = lastName; }
	 * 
	 * @Column(name = "email_address", nullable = false) public String
	 * getEmailId() { return emailId; } public void setEmailId(String emailId) {
	 * this.emailId = emailId; }
	 * 
	 * @Column(name = "created_at", nullable = false)
	 * 
	 * @CreatedDate
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) public Date getCreatedAt() { return
	 * createdAt; } public void setCreatedAt(Date createdAt) { this.createdAt =
	 * createdAt; }
	 * 
	 * @Column(name = "created_by", nullable = false)
	 * 
	 * @CreatedBy public String getCreatedBy() { return createdBy; } public void
	 * setCreatedBy(String createdBy) { this.createdBy = createdBy; }
	 * 
	 * @Column(name = "updated_at", nullable = false)
	 * 
	 * @LastModifiedDate
	 * 
	 * @Temporal(TemporalType.TIMESTAMP) public Date getUpdatedAt() { return
	 * updatedAt; } public void setUpdatedAt(Date updatedAt) { this.updatedAt =
	 * updatedAt; }
	 * 
	 * @Column(name = "updated_by", nullable = false)
	 * 
	 * @LastModifiedBy public String getUpdatedby() { return updatedby; } public
	 * void setUpdatedby(String updatedby) { this.updatedby = updatedby; }
	 */
}
