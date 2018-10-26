package com.lxisoft.byta.repository;

import com.lxisoft.byta.domain.Drug;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Drug entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DrugRepository extends JpaRepository<Drug,Long> {
    
}
