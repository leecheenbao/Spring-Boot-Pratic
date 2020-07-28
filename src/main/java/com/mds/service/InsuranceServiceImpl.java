package com.mds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.mds.model.Insurance;
import com.mds.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepository;

	@Override
	public Iterable<Insurance> findAll() {
		return insuranceRepository.findAll();
	}
	
//	@Override
//	public List<Insurance> search(String id) {
//		return insuranceRepository.findByClassIdContaining(id);
//	}

	@Override
	public Insurance findOne(String id) {
		return insuranceRepository.findOne(id);
	}

	@Override
	public void save(Insurance contact) {
		insuranceRepository.save(contact);
	}

	@Override
	public void delete(String id) {
		insuranceRepository.delete(id);
	}

}