package com.learn.design.ch01_strategyPattern;


public class RocketDuck extends Duck {

    public RocketDuck() {
        flyBehavior = new FlyingByRocket();
    }

}
