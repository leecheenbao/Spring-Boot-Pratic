package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.Insurance;


public interface InsuranceService {

//	List<Insurance> search(String q);

	Insurance findOne(String id);

	void save(Insurance contact);

	void delete(String id);

	Iterable<Insurance> findAll();
}