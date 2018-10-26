package com.lxisoft.byta.web.rest;

//import com.codahale.metrics.annotation.Timed;
import com.lxisoft.byta.domain.Patient;
import com.lxisoft.byta.service.PatientService;
//import com.lxisoft.byta.web.rest.util.HeaderUtil;
//import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Patient.
 */
@RestController
@RequestMapping("/api")
public class PatientResource {

    private final Logger log = LoggerFactory.getLogger(PatientResource.class);

    private static final String ENTITY_NAME = "patient";

    private final PatientService patientService;

    public PatientResource(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * POST  /patients : Create a new patient.
     *
     * @param patient the patient to create
     * @return the ResponseEntity with status 201 (Created) and with body the new patient, or with status 400 (Bad Request) if the patient has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/patients")
  //  @Timed
    public Patient createPatient(@Valid @RequestBody Patient patient) throws URISyntaxException {
        log.debug("REST request to save Patient : {}", patient);
       /* if (patient.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new patient cannot already have an ID")).body(null);
        }*/
        Patient result = patientService.save(patient);
        return  result;/*ResponseEntity.created(new URI("/api/patients/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);*/
    }

    /**
     * PUT  /patients : Updates an existing patient.
     *
     * @param patient the patient to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated patient,
     * or with status 400 (Bad Request) if the patient is not valid,
     * or with status 500 (Internal Server Error) if the patient couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/patients")
    //@Timed
    public Patient updatePatient(@Valid @RequestBody Patient patient) throws URISyntaxException {
        log.debug("REST request to update Patient : {}", patient);
       /* if (patient.getId() == null) {
            return createPatient(patient);
        }*/
        Patient result = patientService.save(patient);
        return result;/*ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, patient.getId().toString()))
            .body(result);*/
    }

    /**
     * GET  /patients : get all the patients.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of patients in body
     */
    @GetMapping("/patients")
  //  @Timed
    public List<Patient> getAllPatients() {
        log.debug("REST request to get all Patients");
        return patientService.findAll();
    }

    /**
     * GET  /patients/:id : get the "id" patient.
     *
     * @param id the id of the patient to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the patient, or with status 404 (Not Found)
     */
    @GetMapping("/patients/{id}")
    //@Timed
    public Patient getPatient(@PathVariable Long id) {
        log.debug("REST request to get Patient : {}", id);
        Patient patient = patientService.findOne(id);
        return  patient;/*ResponseUtil.wrapOrNotFound(Optional.ofNullable(patient));*/
    }

    /**
     * DELETE  /patients/:id : delete the "id" patient.
     *
     * @param id the id of the patient to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/patients/{id}")
  //  @Timed
    public void deletePatient(@PathVariable Long id) {
        log.debug("REST request to delete Patient : {}", id);
        patientService.delete(id);
        //return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
