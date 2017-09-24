package com.spbgti.dispatcherapp.Service;

import com.spbgti.dispatcherapp.Entity.Event.Command.Command;
import com.spbgti.dispatcherapp.Entity.Event.Command.Query;
import com.spbgti.dispatcherapp.Entity.Event.*;
import com.spbgti.dispatcherapp.Repository.mongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("Event Service")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class EventService {

    @Autowired
    private mongoRepository mongoRepository;

    /*@PersistenceContext
    private EntityManager entityManager;*/


    public Object addModifyEvent(Command[] commands) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> result;
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), new Date().toString(), list);
        result = modifyEvent.apply();
        mongoRepository.addSuccessfulEvent(modifyEvent);
        return result;
    }

    public void addFailedModifyEvent(Command[] commands, Exception e) {
        List<Command> list = Arrays.asList(commands);
        FailedEvent failedModifyEvent = new FailedEvent(
                new ModifyEvent(
                        new User(),
                        new SessionInfo(),
                        new Date().toString(),
                        list),
                e.getClass().toString() + " " + e.getMessage());
        mongoRepository.addFailedEvent(failedModifyEvent);
    }

    public Object addReadEvent(Query[] queries) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Object> result;
        List<Query> list = Arrays.asList(queries);
        ReadEvent readEvent = new ReadEvent(new User(), new SessionInfo(), new Date().toString(), list);
        result = readEvent.apply();
        mongoRepository.addSuccessfulEvent(readEvent);
        return result;
    }

    public void addFailedReadEvent(Query[] queries, Exception e) {
        List<Query> list = Arrays.asList(queries);
        FailedEvent failedReadEvent = new FailedEvent(
                new ReadEvent(
                        new User(),
                        new SessionInfo(),
                        new Date().toString(),
                        list),
                e.getClass().toString() + " " + e.getMessage());
        mongoRepository.addFailedEvent(failedReadEvent);
    }
}
