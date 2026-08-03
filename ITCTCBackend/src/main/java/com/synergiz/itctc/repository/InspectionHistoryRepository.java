package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.InspectionHistory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionHistoryRepository extends JpaRepository<InspectionHistory, Long> {

	List<InspectionHistory> findByInspectionWorkflowInspectionWorkflowIdOrderByActionDateAsc(Long inspectionWorkflowId);
}