package com.tem.springbootcrudrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "vehicleid")
	private long vehicleid;
			
	@Column(name = "drivername")
	private String driverName;
	
	@Column(name = "mobileno")
	private String mobileNo;
	
	@Column(name = "vehicleno")
	private String vehicleNo;
	
	@Column(name = "vehicleType")
	private String vehicleType;
	
	@Column(name = "fc")
	private String fc;
	
	@Column(name = "fcdate")
	private String fcdate;
	
	@Column(name = "insurancedate")
	private String insurancedate; 
	
	@Column(name = "insurance")
	private String insurance;
	
	@Column(name = "rcno")
	private String rCNo;
	
	@Column(name = "roadtax")
	private String roadTax;
	
	@Column(name = "pollutioncert")
	private String pollutioncert;
	
	@Column(name = "goodpermit")
	private String goodPermit;
	
	@Column(name = "statePermit")
	private String statePermit;
	
	@Column(name = "modifieddate")
	private String modifiedDate;
	
	@Column(name = "createddate")
	private String createdDate;
	
	@Column(name = "Createdby", nullable = true)
	private String createdby;
	
	@Column(name = "fixedamt")
	private String fixedamt;
	
	@Column(name = "perkmamt")
	private String perkmamt;
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private Vendor vendorandvehicle;

	
	public String getFcdate() {
		return fcdate;
	}

	public void setFcdate(String fcdate) {
		this.fcdate = fcdate;
	}

	public String getInsurancedate() {
		return insurancedate;
	}

	public void setInsurancedate(String insurancedate) {
		this.insurancedate = insurancedate;
	}

	public String getFixedamt() {
		return fixedamt;
	}

	public void setFixedamt(String fixedamt) {
		this.fixedamt = fixedamt;
	}

	public String getPerkmamt() {
		return perkmamt;
	}

	public void setPerkmamt(String perkmamt) {
		this.perkmamt = perkmamt;
	}

	public long getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(long vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getrCNo() {
		return rCNo;
	}

	public void setrCNo(String rCNo) {
		this.rCNo = rCNo;
	}

	public String getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(String roadTax) {
		this.roadTax = roadTax;
	}

	public String getPollutioncert() {
		return pollutioncert;
	}

	public void setPollutioncert(String pollutioncert) {
		this.pollutioncert = pollutioncert;
	}

	public String getGoodPermit() {
		return goodPermit;
	}

	public void setGoodPermit(String goodPermit) {
		this.goodPermit = goodPermit;
	}

	public String getStatePermit() {
		return statePermit;
	}

	public void setStatePermit(String statePermit) {
		this.statePermit = statePermit;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Vendor getVendorandvehicle() {
		return vendorandvehicle;
	}

	public void setVendorandvehicle(Vendor vendorandvehicle) {
		this.vendorandvehicle = vendorandvehicle;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}	
	
	
}
