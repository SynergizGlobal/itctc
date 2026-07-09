package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.MeasurementType;

@Repository
public interface MeasurementTypeRepository
        extends JpaRepository<MeasurementType,Integer>{
}