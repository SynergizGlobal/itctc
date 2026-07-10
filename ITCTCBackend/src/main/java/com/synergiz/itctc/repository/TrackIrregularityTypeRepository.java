package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.TrackIrregularityType;

@Repository
public interface TrackIrregularityTypeRepository
        extends JpaRepository<TrackIrregularityType, Integer> {

}