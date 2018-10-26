package com.lxisoft.byta.repository;

import com.lxisoft.byta.domain.Slots;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Slots entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SlotsRepository extends JpaRepository<Slots,Long> {
    
}
