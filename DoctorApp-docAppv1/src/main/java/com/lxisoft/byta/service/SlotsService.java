package com.lxisoft.byta.service;

import com.lxisoft.byta.domain.Slots;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * Service Interface for managing Slots.
 */
public interface SlotsService {

    /**
     * Save a slots.
     *
     * @param slots the entity to save
     * @return the persisted entity
     * 
     */
	void createSlot(Date fromTime,Date endTime,int sloteIntervell);
	
	
	
	
    Slots save(Slots slots);

    /**
     *  Get all the slots.
     *
     *  @return the list of entities
     */
    List<Slots> findAll();

    /**
     *  Get the "id" slots.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    Slots findOne(Long id);

    /**
     *  Delete the "id" slots.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
