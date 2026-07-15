package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.FoulingMarkHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoulingMarkHeaderRepository
        extends JpaRepository<FoulingMarkHeader, Long> {

}