package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.TrackDirection;

@Repository
public interface TrackDirectionRepository
        extends JpaRepository<TrackDirection, Integer> {

}