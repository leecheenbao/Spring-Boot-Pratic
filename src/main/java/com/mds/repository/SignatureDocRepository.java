package com.mds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mds.model.Signature;
import com.mds.model.SignatureDoc;

@Repository
public interface SignatureDocRepository extends JpaRepository<SignatureDoc, String> {

//	@Query(value = "select * from Signature_Doctest WHERE doc_id =?1", nativeQuery = true)
//	List<SignatureDoc> findOneDoc(@Param("id") String doc_id);

	@Query(value = "select * from Signature_Doctest WHERE doc_id =?1 and docsub_id =?2", nativeQuery = true)
	List<SignatureDoc> findOneDoc(@Param("id") String doc_id, @Param("docsub_id") String docsub_id);

}