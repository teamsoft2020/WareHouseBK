package com.tem.springbootcrudrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "accesses")
@EntityListeners(AuditingEntityListener.class)
public class Accesses {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "accessesid")
	private long id;

	@Column(name = "screenname")
	private String screenname;

	@Column(name = "add")
	private boolean add;

	@Column(name = "edit")
	private boolean edit;

	@Column(name = "delete")
	private String delete;

	@Column(name = "view")
	private boolean view;

	@Column(name = "report")
	private boolean report;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public boolean isView() {
		return view;
	}

	public void setView(boolean view) {
		this.view = view;
	}

	public boolean isReport() {
		return report;
	}

	public void setReport(boolean report) {
		this.report = report;
	}
}
