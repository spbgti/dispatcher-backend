package com.spbgti.dispatcherapp.entity;

import com.spbgti.dispatcherapp.entity.Enum.Type;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_GROUP")
public class Group {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "number_of_group")
    private String numberOfGroup;

    @Column(name = "type")
    private Type type;

    @Column(name = "num")
    private int numOfStudents;

    public Group(){}

    public Group(String numberOfGroup, Type type, int numOfStudents) {
        this.numberOfGroup = numberOfGroup;
        this.type = type;
        this.numOfStudents = numOfStudents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(String numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }
}
