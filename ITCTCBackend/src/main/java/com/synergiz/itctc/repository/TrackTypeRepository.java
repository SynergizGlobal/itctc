package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.TrackType;

@Repository
public interface TrackTypeRepository
        extends JpaRepository<TrackType,Integer>{
}