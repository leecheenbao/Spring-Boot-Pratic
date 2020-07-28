package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.Signature;


public interface SignatureService {

	List<Signature> search(String q);

	Signature findOne(String id);

	void save(Signature contact);

	void delete(String id);

	Iterable<Signature> findAll();
}