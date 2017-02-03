package com.zker.service.main;

import com.zker.model.main.SysMain;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainServiceImplTest {
    ApplicationContext applicationContext;
    MainService mainService;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
        mainService = (MainService) applicationContext.getBean("mainService");
    }

    @After
    public void tearDown() throws Exception {
        applicationContext = null;
        mainService = null;
    }

    @Test
    public void testFindAllMain() throws Exception {
        List<SysMain> lists;
        lists = mainService.findAllMain();
        assertEquals(lists.size(), 0);

    }

    @Test
    public void testSave() throws Exception {

    }
}
