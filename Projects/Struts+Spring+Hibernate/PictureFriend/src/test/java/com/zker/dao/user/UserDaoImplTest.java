package com.zker.dao.user;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.web.context.support.XmlWebApplicationContext;


import static org.junit.Assert.*;

public class UserDaoImplTest {

    ApplicationContext applicationContext;
    String config;
    UserDao userDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        userDao = (UserDao) applicationContext.getBean("userDao");
    }

    @After
    public void tearDown() throws Exception {
        applicationContext = null;
        config = null;
        userDao = null;
    }

    @Test
    public void testFindCount() throws Exception {
        assertEquals(11, userDao.findCount());
    }
}
