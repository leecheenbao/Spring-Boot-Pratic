package com.mds.service;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mds.model.DocList;
import com.mds.model.DocSub;

public interface DocListService {

	DocList findOne(String id);

	void save(DocList contact);

	void delete(String id);

	Iterable<DocList> findAll();
}