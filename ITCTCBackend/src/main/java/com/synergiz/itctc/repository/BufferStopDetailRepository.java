package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.BufferStopDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BufferStopDetailRepository
        extends JpaRepository<BufferStopDetail, Long> {

}