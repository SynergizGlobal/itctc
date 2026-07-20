package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.SleeperSpacingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleeperSpacingDetailRepository
        extends JpaRepository<SleeperSpacingDetail, Long> {

}