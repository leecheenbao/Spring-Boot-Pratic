package com.mds.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "doc")
public class Doc implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "class_id")
	private String class_id;

	@Id
	@Column(name = "doc_id")
	private String doc_id;

	@Column(name = "doc_name")
	private String doc_name;

	@Column(name = "xcode_title")
	private String xcodeTitle;


	public Doc() {
		super();
	}

	public Doc(String class_id, String doc_id, String doc_name, String xcode_title) {
		super();
		this.class_id = class_id;
		this.doc_id = doc_id;
		this.doc_name = doc_name;
		this.xcodeTitle = xcode_title;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getDoc_name() {
		return doc_name;
	}

	public void setDoc_name(String doc_name) {
		this.doc_name = doc_name;
	}

	public String getXcode_title() {
		return xcodeTitle;
	}

	public void setXcode_title(String xcode_title) {
		this.xcodeTitle = xcode_title;
	}

}