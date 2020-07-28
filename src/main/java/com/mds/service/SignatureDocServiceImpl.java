package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.SignatureDoc;
import com.mds.repository.SignatureDocRepository;

@Service
public class SignatureDocServiceImpl implements SignatureDocService {
	@Autowired
	private SignatureDocRepository signaureDocRepository;

	@Override
	public Iterable<SignatureDoc> findAll() {
		return signaureDocRepository.findAll();
	}


	@Override
	public SignatureDoc findOne(String id) {
		return signaureDocRepository.findOne(id);
	}

	@Override
	public void save(SignatureDoc contact) {
		signaureDocRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		signaureDocRepository.delete(id);
	}

}