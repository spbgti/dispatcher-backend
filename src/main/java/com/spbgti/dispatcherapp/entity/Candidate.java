package com.spbgti.dispatcherapp.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value="person")
public class Candidate extends Person{

    @ManyToOne
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    public Candidate() {
    }

    public Candidate(String name, String surname, String patronymic, Speciality speciality) {
        super(name, surname, patronymic);
        this.speciality = speciality;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }
}
