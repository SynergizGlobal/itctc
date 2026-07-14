package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.FasteningBoltHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FasteningBoltHeaderRepository
        extends JpaRepository<FasteningBoltHeader, Long> {

}