package com.mds.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurance")
public class Insurance implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "class_id")
	private String classId;
	@Id
	@Column(name = "insurance_id")
	private String insurance_id;

	@Column(name = "insurance_name")
	private String insurance_name;

	public Insurance() {
		super();
	}

	public Insurance(String class_id, String insurance_id, String insurance_name) {
		super();
		this.classId = class_id;
		this.insurance_id = insurance_name;
	}

	public String getClass_id() {
		return classId;
	}

	public void setClass_id(String class_id) {
		this.classId = class_id;
	}

	public String getInsurance_id() {
		return insurance_id;
	}

	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}

	public String getInsurance_name() {
		return insurance_name;
	}

	public void setInsurance_name(String insurance_name) {
		this.insurance_name = insurance_name;
	}

}