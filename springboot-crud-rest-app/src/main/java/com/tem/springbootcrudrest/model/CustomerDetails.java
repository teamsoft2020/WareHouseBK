package com.tem.springbootcrudrest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "customerDetails")
@EntityListeners(AuditingEntityListener.class)
public class CustomerDetails {
		private long customerDetailId;
		private String customerAddr;
		private String mobileNo;
		private String phoneNo;
		private String gstin;
		
		private Customer customer;
		
		
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name = "id")
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		public long getCustomerDetailId() {
			return customerDetailId;
		}
		public void setCustomerDetailId(long customerDetailId) {
			this.customerDetailId = customerDetailId;
		}
		@Column(name = "Customer_Addr", nullable = false)
		public String getCustomerAddr() {
			return customerAddr;
		}
		public void setCustomerAddr(String customerAddr) {
			this.customerAddr = customerAddr;
		}
		@Column(name = "MobileNo", nullable = false)
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		@Column(name = "phoneNo", nullable = false)
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		@Column(name = "Gstin", nullable = false)
		public String getGstin() {
			return gstin;
		}
		public void setGstin(String gstin) {
			this.gstin = gstin;
		}
}
