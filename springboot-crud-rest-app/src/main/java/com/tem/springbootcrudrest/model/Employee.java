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
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="employeeid")
	private long id;
	
    @Column(name="empid")
	private String empid;
	
    @Column(name="empname")
	private String empname;
	
    @Column(name="role")
	private String role;
	
    @Column(name="designation")
	private String designation;
    
    @Column(name = "pan")
	private String pan;
    
    @Column(name = "yearofexperience")
   	private String yearofexperience;    
    
    @Column(name = "aadtharnumber")
   	private String adtharnumber;
    
    @Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "createddate")
	private Date createddate;
    
    @Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "modifieddate")
	private Date modifieddate;
    
    @Temporal(TemporalType.DATE)
	@LastModifiedDate
	@Column(name = "joindate")
	private Date joindate;
    
    /*@Column(name = "dob")
	private Date dob;*/
	

	@Column(name = "fathername")
	private String fathername;
	
	@Column(name = "salary")
	private String salary;
	
	@Column(name = "employeeAddress")
	private String employeeAddress;
	
	@Column(name = "mobileno")
	private String mobileno;
    
    @JsonManagedReference
	@OneToMany(mappedBy = "employeeaddr", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EmployeeAddress> empployeeaddress;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public List<EmployeeAddress> getEmpployeeaddress() {
		return empployeeaddress;
	}

	public void setEmpployeeaddress(List<EmployeeAddress> empployeeaddress) {
		this.empployeeaddress = empployeeaddress;
	}


	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getYearofexperience() {
		return yearofexperience;
	}

	public void setYearofexperience(String yearofexperience) {
		this.yearofexperience = yearofexperience;
	}

	public String getAdtharnumber() {
		return adtharnumber;
	}

	public void setAdtharnumber(String adtharnumber) {
		this.adtharnumber = adtharnumber;
	}

	public Date getCreateddate() {
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
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	
	/*public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}*/

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
}
