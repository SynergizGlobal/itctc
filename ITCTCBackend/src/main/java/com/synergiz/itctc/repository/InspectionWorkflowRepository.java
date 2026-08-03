package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.InspectionWorkflow;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionWorkflowRepository extends JpaRepository<InspectionWorkflow, Long> {

	Optional<InspectionWorkflow> findByInspectionFormInspectionFormIdAndReferenceId(
	        Integer inspectionFormId,
	        Long referenceId);
	
}