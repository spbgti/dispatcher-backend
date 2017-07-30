package com.spbgti.dispatcherapp.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@DiscriminatorValue(value="teacher")
public class Teacher extends Person{

    @ManyToOne
    @JoinColumn(name = "chair_id", nullable = false)
    private Chair chair;

    public Teacher(){

    }

    public Teacher(String name, String surname, String patronymic, Chair chair) {
        super(name, surname, patronymic);
        this.chair = chair;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
