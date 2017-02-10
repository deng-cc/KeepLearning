package com.zker.aop.aspect;

import org.aspectj.lang.JoinPoint;

public class TestAfter {

    /**
     * 后置AOP的切面程序，可获取目标函数的返回值
     *
     * @param joinPoint
     * @param obj
     */
    public void doAfter(JoinPoint joinPoint, Object obj) {
        System.out.println("后置方法执行");
        System.out.println("obj为目标组件方法的返回值：" + obj);
    }

    /**
     * 后置AOP的切面程序，没有形参
     */
    public void doAfterNoParam() {
        System.out.println("No param doAfter() method start running");
    }
}
