package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.BufferStopHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BufferStopHeaderRepository
        extends JpaRepository<BufferStopHeader, Long> {

}