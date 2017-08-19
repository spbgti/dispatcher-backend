package com.spbgti.dispatcherapp.Service;

import com.spbgti.dispatcherapp.Entity.Event.Command;
import com.spbgti.dispatcherapp.Entity.Event.ModifyEvent;
import com.spbgti.dispatcherapp.Entity.Event.SessionInfo;
import com.spbgti.dispatcherapp.Entity.Event.User;
import com.spbgti.dispatcherapp.Entity.Faculty;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service("Event Service")
//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class EventService {

    @PersistenceContext
    private EntityManager entityManager;

    //todo: able to cancel the transaction
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Object addModifyEvent(Command[] commands){
        List<Object> result = null;
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), list);

        try {
            /*entityManager.getTransaction().begin();*/
            result = modifyEvent.apply(entityManager);
            /*entityManager.getTransaction().commit();*/
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            /*entityManager.getTransaction().rollback();*/
            result = new ArrayList<>();
            result.add(e.getClass().toString() + e.getMessage());
        }
        return result;
    }

    /*public Collection getAll(){
        return entityManager.createQuery("SELECT f FROM Faculty f", Faculty.class).getResultList();
    }*/
}
