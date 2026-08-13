package com.synergiz.itctc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergiz.itctc.entity.C0ElevationClearanceHeader;

@Repository
public interface C0ElevationClearanceHeaderRepository extends JpaRepository<C0ElevationClearanceHeader, Long> {
	List<C0ElevationClearanceHeader> findByIsActiveTrue();
}