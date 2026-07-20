package com.synergiz.itctc.repository;


import com.synergiz.itctc.entity.SyntheticResinInjectionDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticResinInjectionDetailRepository
        extends JpaRepository<SyntheticResinInjectionDetail, Long> {

}