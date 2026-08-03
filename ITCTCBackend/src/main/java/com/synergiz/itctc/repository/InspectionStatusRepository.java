package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.InspectionStatus;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionStatusRepository extends JpaRepository<InspectionStatus, Integer> {

	 Optional<InspectionStatus> findByStatusCode(String statusCode);
}