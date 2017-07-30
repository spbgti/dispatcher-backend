package com.spbgti.dispatcherapp.entity;

import com.spbgti.dispatcherapp.entity.Enum.Type;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

/**
 * Created by Gilbord on 29.07.2017.
 */
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "group number")
    private String groupNumber;

    @Column(name = "type")
    private Type type;

    @Column(name = "num")
    private int numOfStudents;

    public Group(){}

    public Group(String groupNumber, Type type, int numOfStudents) {
        this.groupNumber = groupNumber;
        this.type = type;
        this.numOfStudents = numOfStudents;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumberr(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getNumOfStudentsm() {
        return numOfStudents;
    }

    public void setNumOfStudents(int numOfStudents) {
        this.numOfStudents = numOfStudents;
    }
}
