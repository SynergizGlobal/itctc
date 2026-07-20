package com.synergiz.itctc.repository;



import com.synergiz.itctc.entity.SyntheticResinInjectionHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheticResinInjectionHeaderRepository
        extends JpaRepository<SyntheticResinInjectionHeader, Long> {

}