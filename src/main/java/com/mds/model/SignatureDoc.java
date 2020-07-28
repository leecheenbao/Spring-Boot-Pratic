package com.mds.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signature_doctest")
public class SignatureDoc implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "group_id")
	private String group_id;

	@Column(name = "insurance_id")
	private String insurance_id;

	@Column(name = "doc_id")
	private String doc_id;

	@Column(name = "epeoplename")
	private String epeoplename;

	@Column(name = "docsub_id")
	private String docsub_id;

	public SignatureDoc() {
		super();
	}

	public SignatureDoc(String group_id, String insurance_id, String doc_id, String epeoplename, String docsub_id) {
		super();
		this.group_id = group_id;
		this.insurance_id = insurance_id;
		this.doc_id = doc_id;
		this.epeoplename = epeoplename;
		this.docsub_id = docsub_id;
	}

	public String getDocsub_id() {
		return docsub_id;
	}

	public void setDocsub_id(String docsub_id) {
		this.docsub_id = docsub_id;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getInsurance_id() {
		return insurance_id;
	}

	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getEpeoplename() {
		return epeoplename;
	}

	public void setEpeoplename(String epeoplename) {
		this.epeoplename = epeoplename;
	}

}