package com.learn.design.ch01_strategyPattern;


public class Duck {
    protected FlyBehavior flyBehavior;
    private String name;
    private int size;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public String performFly() {
        return flyBehavior.fly();
    }

    public String swim() {
        return "Swimming ~ ~ ~";
    }
}
