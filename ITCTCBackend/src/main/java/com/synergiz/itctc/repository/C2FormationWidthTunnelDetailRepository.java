package com.synergiz.itctc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.C2FormationWidthTunnelDetail;

@Repository
public interface C2FormationWidthTunnelDetailRepository
        extends JpaRepository<C2FormationWidthTunnelDetail, Long> {
} 