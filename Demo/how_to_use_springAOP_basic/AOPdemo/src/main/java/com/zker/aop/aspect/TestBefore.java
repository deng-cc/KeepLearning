package com.zker.aop.aspect;

import org.aspectj.lang.JoinPoint;

public class TestBefore {

    /**
     * 用来测试AOP中前置通知的方法（切面程序）
     *
     * 特点：
     * 1、Spring组件中的某个方法（即也是以函数为单位）
     * 2、无返回值类型
     * 3、方法参数类型与通知类型有关（前置通知的形参为JoinPoint类型，也可以无参，但是有参则可以使用其API）
     *
     * @param joinPoint
     */
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("获取传递给目标方法的参数值：" + joinPoint.getArgs()[0]);
        System.out.println("获取目标方法的java反射对象：" + joinPoint.getSignature());
        System.out.println("获取目标对象：" + joinPoint.getTarget());
        System.out.println("testBefore的doBefore执行完毕");
    }

}
