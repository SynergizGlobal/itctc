package com.synergiz.itctc.repository;


import com.synergiz.itctc.entity.CamMeasurementHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamMeasurementHeaderRepository
        extends JpaRepository<CamMeasurementHeader, Long> {

}