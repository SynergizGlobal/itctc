package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.StructureType;

@Repository
public interface StructureTypeRepository
        extends JpaRepository<StructureType,Integer>{
}