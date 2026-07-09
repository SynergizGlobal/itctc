package com.synergiz.itctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.MeasurementHeader;

@Repository
public interface MeasurementHeaderRepository
        extends JpaRepository<MeasurementHeader,Long>{
	
	 List<MeasurementHeader> findByIsActiveTrue();
}