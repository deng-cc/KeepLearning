package com.zker.aop.bean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TargetTest {
    ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
    }

    @After
    public void tearDown() throws Exception {
        applicationContext = null;
    }

    @Test
    public void testSave() throws Exception {
        Target target = (Target)applicationContext.getBean("target");
        System.out.println(target.save("UselessPara"));
    }
}
