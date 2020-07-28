package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.Signature;
import com.mds.repository.SignatureRepository;


@Service
public class SignatureServiceImpl implements SignatureService {
	@Autowired
	private SignatureRepository signaureRepository;

	@Override
	public Iterable<Signature> findAll() {
		return signaureRepository.findAll();
	}

	@Override
	public List<Signature> search(String id) {
		return signaureRepository.findByEpeoplenameContaining(id);
	}

	@Override
	public Signature findOne(String id) {
		return signaureRepository.findOne(id);
	}

	@Override
	public void save(Signature contact) {
		signaureRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		signaureRepository.delete(id);
	}


}