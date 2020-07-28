package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.DocSub;

public interface DocSubService {


	DocSub findOne(String id);

	void save(DocSub contact);

	void delete(String id);

	Iterable<DocSub> findAll();
}