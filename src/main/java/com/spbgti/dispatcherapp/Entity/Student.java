package com.spbgti.dispatcherapp.Entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="student")
public class Student extends Person{

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    public Student() {
    }

    public Student(String name, String surname, String patronymic, Group group) {
        super(name, surname, patronymic);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
