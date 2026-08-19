package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.C4StructureGaugeHeader;

@Repository
public interface C4StructureGaugeHeaderRepository
        extends JpaRepository<C4StructureGaugeHeader, Long> {

}
