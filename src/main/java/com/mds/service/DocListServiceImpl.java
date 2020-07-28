package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.DocList;
import com.mds.model.DocSub;
import com.mds.repository.DocListRepository;
import com.mds.repository.DocSubRepository;

@Service
public class DocListServiceImpl implements DocListService {
	@Autowired
	private DocListRepository doclistRepository;

	@Override
	public Iterable<DocList> findAll() {
		return doclistRepository.findAll();
	}

	@Override
	public DocList findOne(String id) {
		return doclistRepository.findOne(id);
	}

	@Override
	public void save(DocList contact) {
		doclistRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		doclistRepository.delete(id);
	}

}