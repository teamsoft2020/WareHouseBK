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

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "customerDetails")
@EntityListeners(AuditingEntityListener.class)
public class CustomerDetails {
		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private long customerDetailId;
		@Column(name = "Customer_Addr", nullable = false)
		private String customerAddr;
		@Column(name = "MobileNo", nullable = false)
		private String mobileNo;
		@Column(name = "phoneNo", nullable = false)
		private String phoneNo;
		@Column(name = "Gstin", nullable = false)
		private String gstin;
		
		@JsonBackReference
		@ManyToOne(fetch=FetchType.EAGER)
		@JoinColumn(name = "id")
		private Customer customeranddcustomeretails;
		
		
		/*
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}*/
		
		public long getCustomerDetailId() {
			return customerDetailId;
		}
		public Customer getCustomeranddcustomeretails() {
			return customeranddcustomeretails;
		}
		public void setCustomeranddcustomeretails(Customer customeranddcustomeretails) {
			this.customeranddcustomeretails = customeranddcustomeretails;
		}
		public void setCustomerDetailId(long customerDetailId) {
			this.customerDetailId = customerDetailId;
		}
		
		public String getCustomerAddr() {
			return customerAddr;
		}
		public void setCustomerAddr(String customerAddr) {
			this.customerAddr = customerAddr;
		}
		
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		
		public String getPhoneNo() {
			return phoneNo;
		}
		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}
		
		public String getGstin() {
			return gstin;
		}
		public void setGstin(String gstin) {
			this.gstin = gstin;
		}
}
