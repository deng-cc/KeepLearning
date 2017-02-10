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
        System.out.println("------------------------");
        System.out.println("执行目标函数");
        //System.out.println("异常出现：" + 10/0); //抛出异常的情况
        System.out.println("------------------------");
        return "保存成功";
    }

}
