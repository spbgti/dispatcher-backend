package com.spbgti.dispatcherapp.entity;

import com.spbgti.dispatcherapp.entity.Enum.EducationForm;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_GROUP")
public class Group {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "education_form",  nullable = false)
    private EducationForm educationForm;

    public Group(){}

    public Group(String name, EducationForm educationForm) {
        this.name = name;
        this.educationForm = educationForm;
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

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }
}
