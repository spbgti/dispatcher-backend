package com.spbgti.dispatcherapp.Repository;

import com.spbgti.dispatcherapp.Entity.Event.ClassParser;
import com.spbgti.dispatcherapp.Entity.Event.Command.CreateCommand;
import com.spbgti.dispatcherapp.Entity.Event.Command.DeleteCommand;
import com.spbgti.dispatcherapp.Entity.Event.Command.QueryImpl;
import com.spbgti.dispatcherapp.Entity.Event.Command.UpdateCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Component(value = "Entity Repository")
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
public class EntityRepository {


    @PersistenceContext
    private EntityManager entityManager;


    public EntityRepository() {

    }

    public Object create(CreateCommand createCommand) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object object = new ClassParser().parse((LinkedHashMap) createCommand.getEntity(), createCommand.getType());
        entityManager.persist(object);
        return object;
    }

    public Object update(UpdateCommand command) throws ClassNotFoundException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        String sqlQuery = "UPDATE " + new ClassParser().firstCharToUpperCase(command.getType())
                + " SET " + command.getField()
                + " " + " = :fieldValue "
                + "WHERE id = :idValue";
        Object newObject = new ClassParser().parse((LinkedHashMap) command.getNewEntity(), command.getType());
        Object field = new ClassParser().getField((LinkedHashMap) command.getNewEntity(),
                command.getType(), command.getField());
        entityManager
                .createQuery(sqlQuery)
                .setParameter("fieldValue", field)
                .setParameter("idValue", (long) command.getEntityId())
                .executeUpdate();
        return newObject;
    }

    public Object delete(DeleteCommand deleteCommand) {
        String sqlQuery = "DELETE "
                + new ClassParser().firstCharToUpperCase(deleteCommand.getType())
                + " WHERE id = :idValue";
        entityManager.createQuery(sqlQuery).setParameter("idValue",
                (long) deleteCommand.getEntityId()).executeUpdate();
        return null;
    }

    public List executeQuery(QueryImpl executableQuery) throws ClassNotFoundException {
        String sqlString = "SELECT *" + " FROM " + new ClassParser().firstCharToUpperCase(executableQuery.getType());
        Set set = ((LinkedHashMap) executableQuery.getParams()).entrySet();
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
        javax.persistence.Query query = entityManager.createNativeQuery(sqlString,
                new ClassParser().getClassFor(executableQuery.getType()));
        set = ((LinkedHashMap) executableQuery.getParams()).entrySet();
        i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            query.setParameter(me.getKey().toString() + "Value", me.getValue());
        }
        return query.getResultList();
    }

}
