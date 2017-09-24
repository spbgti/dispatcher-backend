package com.spbgti.dispatcherapp.Entity.Event.Command;

import com.spbgti.dispatcherapp.Entity.Event.ClassParser;
import com.spbgti.dispatcherapp.Repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.*;

public class Query implements Command{
    private String type;
    private boolean oneOrMany;
    private Object params;

    @Autowired
    EntityRepository entityRepository;

    public Query() {
    }

    public Query(String type, boolean oneOrMany, Object params) {
        this.type = type;
        this.oneOrMany = oneOrMany;
        this.params = params;
    }

    public List apply() throws ClassNotFoundException {
        return entityRepository.executeQuery(this);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOneOrMany() {
        return oneOrMany;
    }

    public void setOneOrMany(boolean oneOrMany) {
        this.oneOrMany = oneOrMany;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }
}
