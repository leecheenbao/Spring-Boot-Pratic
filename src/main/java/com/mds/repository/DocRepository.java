package com.mds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mds.model.Doc;
import com.mds.model.SignatureDoc;



@Repository
public interface DocRepository extends JpaRepository<Doc, String> {

	List<Doc> findByXcodeTitleContaining(String q);
	
	@Query(value = "select * from doc WHERE class_id =?1", nativeQuery = true)
	List<Doc> findOneClassDoc(@Param("id") String class_id);
}