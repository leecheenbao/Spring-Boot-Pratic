package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.Doc;
import com.mds.repository.DocRepository;


@Service
public class DocServiceImpl implements DocService {
	@Autowired
	private DocRepository docRepository;

	@Override
	public Iterable<Doc> findAll() {
		return docRepository.findAll();
	}

	@Override
	public List<Doc> search(String id) {
		return docRepository.findByXcodeTitleContaining(id);
	}

	@Override
	public Doc findOne(String id) {
		return docRepository.findOne(id);
	}

	@Override
	public void save(Doc contact) {
		docRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		docRepository.delete(id);
	}


}