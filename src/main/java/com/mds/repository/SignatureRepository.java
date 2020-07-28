package com.mds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mds.model.Signature;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, String> {

	List<Signature> findByEpeoplenameContaining(String q);
	
	
	@Query(value = "select * from Signature order by seq", nativeQuery = true)
	List<Signature> findAllOrderBySeq();
	
}