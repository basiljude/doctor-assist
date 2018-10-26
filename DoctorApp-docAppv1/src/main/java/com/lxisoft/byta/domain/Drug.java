package com.lxisoft.byta.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Drug.
 */
@Entity
@Table(name = "drug")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "drug_id")
    private Long drugId;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "dosage")
    private Long dosage;

    @Column(name = "instruction")
    private String instruction;

    @Column(name = "course_time")
    private Long courseTime;

    @ManyToOne
    private Prescription prescription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrugId() {
        return drugId;
    }

    public Drug drugId(Long drugId) {
        this.drugId = drugId;
        return this;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public Drug drugName(String drugName) {
        this.drugName = drugName;
        return this;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Long getDosage() {
        return dosage;
    }

    public Drug dosage(Long dosage) {
        this.dosage = dosage;
        return this;
    }

    public void setDosage(Long dosage) {
        this.dosage = dosage;
    }

    public String getInstruction() {
        return instruction;
    }

    public Drug instruction(String instruction) {
        this.instruction = instruction;
        return this;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Long getCourseTime() {
        return courseTime;
    }

    public Drug courseTime(Long courseTime) {
        this.courseTime = courseTime;
        return this;
    }

    public void setCourseTime(Long courseTime) {
        this.courseTime = courseTime;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Drug prescription(Prescription prescription) {
        this.prescription = prescription;
        return this;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Drug drug = (Drug) o;
        if (drug.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), drug.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Drug{" +
            "id=" + getId() +
            ", drugId='" + getDrugId() + "'" +
            ", drugName='" + getDrugName() + "'" +
            ", dosage='" + getDosage() + "'" +
            ", instruction='" + getInstruction() + "'" +
            ", courseTime='" + getCourseTime() + "'" +
            "}";
    }
}
