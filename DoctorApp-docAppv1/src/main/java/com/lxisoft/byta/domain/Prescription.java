package com.lxisoft.byta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Prescription.
 */
@Entity
@Table(name = "prescription")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Prescription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "prescription_id")
    private Long prescriptionId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "jhi_date")
    private LocalDate date;

    @ManyToOne
    private Patient patient;

    @OneToMany(mappedBy = "prescription")
    @JsonIgnore
  //  @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Drug> drugs = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public Prescription prescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
        return this;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Prescription doctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public Prescription date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Prescription patient(Patient patient) {
        this.patient = patient;
        return this;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Set<Drug> getDrugs() {
        return drugs;
    }

    public Prescription drugs(Set<Drug> drugs) {
        this.drugs = drugs;
        return this;
    }

    public Prescription addDrugs(Drug drug) {
        this.drugs.add(drug);
        drug.setPrescription(this);
        return this;
    }

    public Prescription removeDrugs(Drug drug) {
        this.drugs.remove(drug);
        drug.setPrescription(null);
        return this;
    }

    public void setDrugs(Set<Drug> drugs) {
        this.drugs = drugs;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Prescription prescription = (Prescription) o;
        if (prescription.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), prescription.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Prescription{" +
            "id=" + getId() +
            ", prescriptionId='" + getPrescriptionId() + "'" +
            ", doctorName='" + getDoctorName() + "'" +
            ", date='" + getDate() + "'" +
            "}";
    }
}
