package com.mds.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "signature")
public class Signature implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "epeoplename")
	private String epeoplename;

	@Column(name = "signature_name")
	private String signature_name;

	@Column(name = "signpattern")
	private String signpattern;

	@Column(name = "seq")
	private Integer seq;

	public Signature() {
		super();
	}

	public Signature(String epeoplename, String signatur_name, String signpattern, Integer seq) {
		super();
		this.epeoplename = epeoplename;
		this.signature_name = signatur_name;
		this.signpattern = signpattern;
		this.seq = seq;
	}

	public String getEpeoplename() {
		return epeoplename;
	}

	public void setEpeoplename(String epeoplename) {
		this.epeoplename = epeoplename;
	}

	public String getSignature_name() {
		return signature_name;
	}

	public void setSignature_name(String signature_name) {
		this.signature_name = signature_name;
	}

	public String getSignpattern() {
		return signpattern;
	}

	public void setSignpattern(String signpattern) {
		this.signpattern = signpattern;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	

}