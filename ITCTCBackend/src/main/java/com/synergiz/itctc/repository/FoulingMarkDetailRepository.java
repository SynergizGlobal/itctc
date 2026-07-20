package com.synergiz.itctc.repository;

import com.synergiz.itctc.entity.FoulingMarkDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoulingMarkDetailRepository
        extends JpaRepository<FoulingMarkDetail, Long> {

}
