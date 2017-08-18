package com.spbgti.dispatcherapp.Service;

import com.spbgti.dispatcherapp.Entity.Event.Command;
import com.spbgti.dispatcherapp.Entity.Event.ModifyEvent;
import com.spbgti.dispatcherapp.Entity.Event.SessionInfo;
import com.spbgti.dispatcherapp.Entity.Event.User;
import com.spbgti.dispatcherapp.Entity.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.repository.config.RepositoryConfigurationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service("Event Service")
@Transactional
public class EventService {

    @PersistenceContext
    private EntityManager entityManager;

    //todo: able to cancel the transaction

    public Object addModifyEvent(Command[] commands){
        List<Command> list = Arrays.asList(commands);
        ModifyEvent modifyEvent = new ModifyEvent(new User(), new SessionInfo(), list);
        List result = modifyEvent.apply(this.entityManager);
        return result;
    }

    public Collection getAll(){
        return entityManager.createQuery("SELECT f FROM Faculty f", Faculty.class).getResultList();
    }
}
