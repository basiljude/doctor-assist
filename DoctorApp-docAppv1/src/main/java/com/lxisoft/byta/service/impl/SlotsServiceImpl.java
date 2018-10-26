package com.lxisoft.byta.service.impl;

import com.lxisoft.byta.service.SlotsService;
import com.lxisoft.byta.domain.Slots;
import com.lxisoft.byta.repository.SlotsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Service Implementation for managing Slots.
 */
@Service
@Transactional
public class SlotsServiceImpl implements SlotsService{

    private final Logger log = LoggerFactory.getLogger(SlotsServiceImpl.class);

    private final SlotsRepository slotsRepository;

    public SlotsServiceImpl(SlotsRepository slotsRepository) {
        this.slotsRepository = slotsRepository;
    }

    /**
     * Save a slots.
     *
     * @param slots the entity to save
     * @return the persisted entity
     */
    @Override
    public Slots save(Slots slots) {
        log.debug("Request to save Slots : {}", slots);
        return slotsRepository.save(slots);
    }

    /**
     *  Get all the slots.
     *
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<Slots> findAll() {
        log.debug("Request to get all Slots");
        return slotsRepository.findAll();
    }

    /**
     *  Get one slots by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Slots findOne(Long id) {
        log.debug("Request to get Slots : {}", id);
        return slotsRepository.findOne(id);
    }

    /**
     *  Delete the  slots by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Slots : {}", id);
        slotsRepository.delete(id);
    }

	@Override
	public void createSlot(Date fromTime, Date endTime, int sloteIntervell) {
		
		  System.out.println("#################################"+fromTime);
		    System.out.println("#################################"+endTime);
		log.debug("Request to Doctor Slots : {}",fromTime,endTime,sloteIntervell);
		
		
		Boolean active=true;
		 Calendar c = Calendar.getInstance();
		    
		 Date fromTim1=null;
		 Date endTim2=null;
		    c.setTime(fromTime);
		    System.out.println("#################################"+fromTime);
		    System.out.println("#################################"+endTime);
		    
		    System.out.println(c.getTime().before(endTime)+"#####################################");
		    
			while (c.getTime().before(endTime)) {
			    c.add(Calendar.MINUTE, sloteIntervell);
			 	endTim2=c.getTime();
			 	fromTim1=new Date((c.getTime().getTime())-(sloteIntervell*60000));
			 	Slots slote=new Slots(fromTim1,endTim2,active);
			 	slotsRepository.save(slote);

			 	
			}
		
	}
}

