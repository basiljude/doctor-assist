package com.lxisoft.byta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A Doctor.
 */
@Entity
@Table(name = "doctor")
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "license_number")
    private String licenseNumber;

    @Lob
    @Column(name = "doctor_image")
    private byte[] doctorImage;

    @Column(name = "doctor_image_content_type")
    private String doctorImageContentType;

    @OneToMany(mappedBy = "doctor")
  // @JsonIgnore
  // @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Slots> slots = new HashSet<Slots>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Doctor doctorName(String doctorName) {
        this.doctorName = doctorName;
        return this;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getQualification() {
        return qualification;
    }

    public Doctor qualification(String qualification) {
        this.qualification = qualification;
        return this;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Doctor specialization(String specialization) {
        this.specialization = specialization;
        return this;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public Doctor licenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
        return this;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public byte[] getDoctorImage() {
        return doctorImage;
    }

    public Doctor doctorImage(byte[] doctorImage) {
        this.doctorImage = doctorImage;
        return this;
    }

    public void setDoctorImage(byte[] doctorImage) {
        this.doctorImage = doctorImage;
    }

    public String getDoctorImageContentType() {
        return doctorImageContentType;
    }

    public Doctor doctorImageContentType(String doctorImageContentType) {
        this.doctorImageContentType = doctorImageContentType;
        return this;
    }

    public void setDoctorImageContentType(String doctorImageContentType) {
        this.doctorImageContentType = doctorImageContentType;
    }

   /* public Set<Slots> getSlots() {
        return slots;
    }

    public Doctor slots(Set<Slots> slots) {
        this.slots = slots;
        return this;
    }

    public Doctor addSlots(Slots slots) {
        this.slots.add(slots);
        slots.setDoctor(this);
        return this;
    }

    public Doctor removeSlots(Slots slots) {
        this.slots.remove(slots);
        slots.setDoctor(null);
        return this;
    }*/

    public void setSlots(Set<Slots> slots) {
        this.slots = slots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Doctor doctor = (Doctor) o;
        if (doctor.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), doctor.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Doctor{" +
            "id=" + getId() +
            ", doctorName='" + getDoctorName() + "'" +
            ", qualification='" + getQualification() + "'" +
            ", specialization='" + getSpecialization() + "'" +
            ", licenseNumber='" + getLicenseNumber() + "'" +
            ", doctorImage='" + getDoctorImage() + "'" +
            ", doctorImageContentType='" + doctorImageContentType + "'" +
            "}";
    }
}
