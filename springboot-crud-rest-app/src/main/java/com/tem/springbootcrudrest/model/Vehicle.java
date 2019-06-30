package com.tem.springbootcrudrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@Column(name = "truckno")
	private String truckno;

	@Column(name = "rcno")
	private String rcno;

	@Temporal(TemporalType.DATE)
	@Column(name = "fcdate")
	private Date fcdate;

	@Column(name = "tructype")
	private String tructype;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTruckno() {
		return truckno;
	}

	public void setTruckno(String truckno) {
		this.truckno = truckno;
	}

	public String getRcno() {
		return rcno;
	}

	public void setRcno(String rcno) {
		this.rcno = rcno;
	}

	public Date getFcdate() {
		return fcdate;
	}

	public void setFcdate(Date fcdate) {
		this.fcdate = fcdate;
	}

	public String getTructype() {
		return tructype;
	}

	public void setTructype(String tructype) {
		this.tructype = tructype;
	}
	
}
