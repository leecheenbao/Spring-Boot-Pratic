package com.mds.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "docsub")
public class DocSub implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "docsub_id")
	private String docsub_id;

	@Column(name = "sub_title")
	private String sub_title;

	@Column(name = "seq")
	private String seq;

	public DocSub() {
		super();
	}

	public DocSub(String docsub_id, String sub_title, String seq) {
		super();
		this.docsub_id = docsub_id;
		this.sub_title = sub_title;
		this.seq = seq;
	}

	public String getDocsub_id() {
		return docsub_id;
	}

	public void setDocsub_id(String docsub_id) {
		this.docsub_id = docsub_id;
	}

	public String getSub_title() {
		return sub_title;
	}

	public void setSub_title(String sub_title) {
		this.sub_title = sub_title;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

}