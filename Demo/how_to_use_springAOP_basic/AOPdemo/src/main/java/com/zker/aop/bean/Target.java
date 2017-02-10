package com.zker.aop.bean;

public class Target {

    /**
     * 这是一个切入点程序，即目标程序，等待我们插入切面程序
     * （需在xml中配置切入点）
     *
     * @param name
     * @return
     */
    public String save(String name) {
        System.out.println("开始执行目标函数");
        return "保存成功";
    }

}
