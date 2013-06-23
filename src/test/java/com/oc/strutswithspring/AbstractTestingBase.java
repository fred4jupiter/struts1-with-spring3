package com.oc.strutswithspring;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Base class for integration tests with Spring.
 *
 * @author michael
 */
@ContextConfiguration(locations = {"classpath:/META-INF/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class AbstractTestingBase {

    @PersistenceContext
    protected EntityManager entityManager;

}
