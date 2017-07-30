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

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private Type type;

    public Group(){}

    public Group(String name, Type type, int numOfStudents) {
        this.name = name;
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
        return name;
    }

    public void setNumberOfGroup(String name) {
        this.name = name;
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
