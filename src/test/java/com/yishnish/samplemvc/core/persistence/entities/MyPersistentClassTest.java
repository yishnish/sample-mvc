package com.yishnish.samplemvc.core.persistence.entities;

import com.yishnish.samplemvc.core.persistence.MyTransactionalTestCase;
import org.hibernate.Session;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class MyPersistentClassTest extends MyTransactionalTestCase {

    @Test
    public void testPersistence(){
        Session session = sessionFactory.getCurrentSession();
        MyPersistentClass persistent = new MyPersistentClass();
        persistent.setName("save me");
        int id = (Integer) session.save(persistent);
        session.flush();
        session.clear();
        MyPersistentClass reloaded = (MyPersistentClass) session.load(MyPersistentClass.class, id);
        assertThat(reloaded.getName(), equalTo(persistent.getName()));
    }
}
