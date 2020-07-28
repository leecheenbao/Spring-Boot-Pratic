package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.SignatureDoc;

public interface SignatureDocService {

	SignatureDoc findOne(String id);

	void save(SignatureDoc contact);

	void delete(String id);

	Iterable<SignatureDoc> findAll();
}