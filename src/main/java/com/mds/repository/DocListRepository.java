package com.mds.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mds.model.Doc;
import com.mds.model.DocList;

@Repository
public interface DocListRepository extends JpaRepository<DocList, String> {
	
	@Query(value = "select * from doclist WHERE doc_id =?1", nativeQuery = true)
	List<DocList> findOneDoc(@Param("doc_id") String doc_id);
	
//	@Query(value = "select * from doclist order by doc_id", nativeQuery = true)
//	List<DocList> findDoc();
	
}