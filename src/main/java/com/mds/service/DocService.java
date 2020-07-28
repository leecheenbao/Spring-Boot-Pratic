package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.Doc;


public interface DocService {

	List<Doc> search(String q);

	Doc findOne(String id);

	void save(Doc contact);

	void delete(String id);

	Iterable<Doc> findAll();
}