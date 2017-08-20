package com.spbgti.dispatcherapp.Service;

import com.spbgti.dispatcherapp.Entity.Event.*;
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

    public Object addModifyEvent(Command[] commands) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> result = null;
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), list);
        result = modifyEvent.apply(entityManager);
        return result;
    }

    public Object addReadEvent(Query[] queries) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Query> list = Arrays.asList(queries);
        ReadEvent readEvent = new ReadEvent(new User(), new SessionInfo(), list);
        return readEvent.apply(entityManager);
    }
}
