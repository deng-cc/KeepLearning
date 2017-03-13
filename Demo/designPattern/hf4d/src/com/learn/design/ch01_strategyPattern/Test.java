package com.learn.design.ch01_strategyPattern;


public class Test {
    public static void main(String[] args) {
        RocketDuck rocketDuck = new RocketDuck();
        System.out.println(rocketDuck.performFly());

        rocketDuck.setFlyBehavior(new FlyingByWings());
        System.out.println(rocketDuck.performFly());
        
    }
}
