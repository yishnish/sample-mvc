package com.yishnish.samplemvc.core.persistence;

import com.yishnish.samplemvc.MyTestCase;
import com.yishnish.samplemvc.core.persistence.config.MyHibernateConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@ContextConfiguration(classes = {MyHibernateConfig.class})
public abstract class MyTransactionalTestCase extends MyTestCase {

    @Autowired
    protected SessionFactory sessionFactory;

}
