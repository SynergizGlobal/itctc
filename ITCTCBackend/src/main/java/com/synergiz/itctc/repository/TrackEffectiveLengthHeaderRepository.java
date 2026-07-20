package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.TrackEffectiveLengthHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackEffectiveLengthHeaderRepository
        extends JpaRepository<TrackEffectiveLengthHeader, Long> {

}