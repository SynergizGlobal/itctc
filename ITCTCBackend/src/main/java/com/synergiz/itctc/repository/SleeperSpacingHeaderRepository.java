package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.SleeperSpacingHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleeperSpacingHeaderRepository
        extends JpaRepository<SleeperSpacingHeader, Long> {

}