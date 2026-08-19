package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.C4StructureGaugeDetail;

@Repository
public interface C4StructureGaugeDetailRepository
        extends JpaRepository<C4StructureGaugeDetail, Long> {

}
