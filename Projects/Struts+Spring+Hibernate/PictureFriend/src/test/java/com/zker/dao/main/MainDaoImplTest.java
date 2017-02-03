package com.zker.dao.main;

import com.zker.model.main.SysMain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainDaoImplTest {
    ApplicationContext applicationContext;
    MainDao mainDao;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        mainDao = (MainDao) applicationContext.getBean("mainDao");
    }

    @After
    public void tearDown() throws Exception {
        applicationContext = null;
        mainDao = null;
    }

    @Test
    public void testFindAll() throws Exception {
        List<SysMain> lists;
        lists = mainDao.findAll();
        assertEquals(lists.size(), 0);
        for (SysMain temp : lists) {
            System.out.println(temp.getImageName());
        }
    }
}
