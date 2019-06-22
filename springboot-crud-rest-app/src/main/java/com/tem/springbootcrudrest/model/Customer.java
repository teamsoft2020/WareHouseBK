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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@Table(name = "customers")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	 
	private Long id;
	private long customerId;
	private String customerName;
	private String PAN;
	private String TAN;
	private String KYC;
	private String IEC;
	private Date createdAt;
	private String createdby;
    
    private List<CustomerDetails> CustomerDetails;
    @OneToMany(targetEntity=CustomerDetails.class,mappedBy = "customer",fetch=FetchType.EAGER)
	public List<CustomerDetails> getCustomerDetails() {
		return CustomerDetails;
	}
	public void setCustomerDetails(List<CustomerDetails> customerDetails) {
		CustomerDetails = customerDetails;
	} 
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "Customer_Id", unique = true, nullable = false)
	public long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	@Column(name = "Customer_name", nullable = false)
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "Created_At", nullable = true)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@Column(name = "Created_by", nullable = true)
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	@Column(name = "pan", nullable = true)
	public String getPAN() {
		return PAN;
	}
	public void setPAN(String pAN) {
		PAN = pAN;
	}
	@Column(name = "tan", nullable = true)
	public String getTAN() {
		return TAN;
	}
	public void setTAN(String tAN) {
		TAN = tAN;
	}
	@Column(name = "kyc", nullable = true)
	public String getKYC() {
		return KYC;
	}
	public void setKYC(String kYC) {
		KYC = kYC;
	}
	@Column(name = "iec", nullable = true)
	public String getIEC() {
		return IEC;
	}
	public void setIEC(String iEC) {
		IEC = iEC;
	}
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "email_address", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "created_at", nullable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Column(name = "created_by", nullable = false)
	@CreatedBy
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name = "updated_at", nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Column(name = "updated_by", nullable = false)
	@LastModifiedBy
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}*/
}
