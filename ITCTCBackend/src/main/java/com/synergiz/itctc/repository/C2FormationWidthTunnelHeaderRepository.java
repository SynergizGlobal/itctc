package com.synergiz.itctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.C2FormationWidthTunnelHeader;

@Repository
public interface C2FormationWidthTunnelHeaderRepository
        extends JpaRepository<C2FormationWidthTunnelHeader, Long> {

    List<C2FormationWidthTunnelHeader> findByIsActiveTrue();
} 