package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.TrackEffectiveLengthDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackEffectiveLengthDetailRepository
        extends JpaRepository<TrackEffectiveLengthDetail, Long> {

}
