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
@Table(name = "doclist")
public class DocList implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "guid")
	private String guid;

	@Column(name = "doc_id")
	private String doc_id;

	@Column(name = "docsub_id")
	private String docsub_id;

	public DocList() {
		super();
	}

	public DocList(String guid, String doc_id, String docsub_id) {
		super();
		this.guid = guid;
		this.doc_id = doc_id;
		this.docsub_id = docsub_id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getDoc_id() {
		return doc_id;
	}

	public void setDoc_id(String doc_id) {
		this.doc_id = doc_id;
	}

	public String getDocsub_id() {
		return docsub_id;
	}

	public void setDocsub_id(String docsub_id) {
		this.docsub_id = docsub_id;
	}

}