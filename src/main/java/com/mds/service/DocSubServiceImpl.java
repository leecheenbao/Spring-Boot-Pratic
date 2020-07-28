package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.DocSub;
import com.mds.repository.DocSubRepository;

@Service
public class DocSubServiceImpl implements DocSubService {
	@Autowired
	private DocSubRepository docsubRepository;

	@Override
	public Iterable<DocSub> findAll() {
		return docsubRepository.findAll();
	}

	@Override
	public DocSub findOne(String id) {
		return docsubRepository.findOne(id);
	}

	@Override
	public void save(DocSub contact) {
		docsubRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		docsubRepository.delete(id);
	}

}