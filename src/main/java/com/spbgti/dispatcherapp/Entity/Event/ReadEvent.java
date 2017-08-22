package com.spbgti.dispatcherapp.Entity.Event;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "ReadEvent")
public class ReadEvent extends Event {
    private List<Query> queries;

    public ReadEvent() {
    }

    public ReadEvent(User user, SessionInfo session, String date, List<Query> queries) {
        super(user, session, date);
        this.queries = queries;
    }

    @Override
    public List<Object> apply(EntityManager entityManager) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        List<Object> result = new ArrayList<>();
        for (Query query : queries) {
            result.add(query.apply(entityManager));
        }
        return result;
    }
}
