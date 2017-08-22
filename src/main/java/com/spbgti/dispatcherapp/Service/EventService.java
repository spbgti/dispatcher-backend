package com.spbgti.dispatcherapp.Service;

import com.spbgti.dispatcherapp.Entity.Event.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

@Service("Event Service")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class EventService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MongoOperations mongoOperations;

    public Object addModifyEvent(Command[] commands) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> result;
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), list);
        result = modifyEvent.apply(entityManager);
        mongoOperations.insert(modifyEvent, "successfulModifyEvent");
        return result;
    }

    public void addFailedModifyEvent(Command[] commands) {
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), list);
        mongoOperations.insert(modifyEvent, "failedModifyEvent");
    }

    public Object addReadEvent(Query[] queries) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> result;
        List<Query> list = Arrays.asList(queries);
        ReadEvent readEvent = new ReadEvent(new User(), new SessionInfo(), list);
        result = readEvent.apply(entityManager);
        mongoOperations.insert(readEvent, "successfulReadEvent");
        return result;
    }

    public void addFailedReadEvent(Query[] queries) {
        List<Query> list = Arrays.asList(queries);
        ReadEvent readEvent = new ReadEvent(new User(), new SessionInfo(), list);
        mongoOperations.insert(readEvent, "failedReadEvent");
    }
}
