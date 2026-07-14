package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.FasteningBoltDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FasteningBoltDetailRepository
        extends JpaRepository<FasteningBoltDetail, Long> {

}