package com.spbgti.dispatcherapp.Entity.Event;

import javax.persistence.EntityManager;
import java.util.*;

public class Query {
    private String type;
    private boolean oneOrMany;
    private Object params;

    public Query() {
    }

    public Query(String type, boolean oneOrMany, Object params) {
        this.type = type;
        this.oneOrMany = oneOrMany;
        this.params = params;
    }

    public List apply(EntityManager entityManager) throws ClassNotFoundException {
        String sqlString = "SELECT *" /*+ this.type*/ + " FROM " + new ClassParser().firstCharToUpperCase(this.type);// + " f ";
        Set set = ((LinkedHashMap) this.params).entrySet();
        Iterator i = set.iterator();
        if (i.hasNext()) {
            sqlString += " WHERE ";
        }
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            if (i.hasNext()) {
                sqlString += me.getKey().toString() + " = :" + me.getKey().toString() + "Value AND ";
            } else {
                sqlString += me.getKey().toString() + " = :" + me.getKey().toString() + "Value";
            }
        }
        System.out.println(sqlString);
        javax.persistence.Query query = entityManager.createNativeQuery(sqlString, new ClassParser().getClassFor(this.type));
        set = ((LinkedHashMap) this.params).entrySet();
        i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            query.setParameter(me.getKey().toString() + "Value", me.getValue());
        }
        return query.getResultList();
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
