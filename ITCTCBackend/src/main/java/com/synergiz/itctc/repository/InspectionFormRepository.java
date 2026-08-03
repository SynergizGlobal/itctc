package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.InspectionForm;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionFormRepository extends JpaRepository<InspectionForm, Integer> {

	Optional<InspectionForm> findByTableName(String tableName);

    Optional<InspectionForm> findByFormCode(String formCode);
	
}