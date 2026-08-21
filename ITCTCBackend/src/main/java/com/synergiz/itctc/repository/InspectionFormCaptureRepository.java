package com.synergiz.itctc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.InspectionFormCapture;

@Repository
public interface InspectionFormCaptureRepository extends JpaRepository<InspectionFormCapture, Long> {

	Optional<InspectionFormCapture> findByInspectionFormIdAndReferenceIdAndIsActiveTrue(Integer inspectionFormId,
			Long referenceId);
}
