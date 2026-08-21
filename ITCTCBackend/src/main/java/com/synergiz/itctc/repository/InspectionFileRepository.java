package com.synergiz.itctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.InspectionFile;

@Repository
public interface InspectionFileRepository extends JpaRepository<InspectionFile, Long> {

	List<InspectionFile> findByInspectionFormIdAndReferenceIdAndIsActiveTrue(Integer inspectionFormId,
			Long referenceId);
}
