package com.zker.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtils implements ApplicationContextAware {
    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context)
            throws BeansException {
        SpringContextUtils.context = context;
    }

    public static <T> T getBean(String beanId,Class<T> clazz){
        return context.getBean(beanId, clazz);
    }

    public static ApplicationContext getContext(){
        return context;
    }

}
