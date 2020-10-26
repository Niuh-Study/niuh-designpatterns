package com.niuh.designpattern.strategy.v1;

/**
 * 未使用策略模式
 */
public class StrategyPattern {

    public static void main(String[] args) {
        AbstractZombie normalZombie = new NormalZombie();
        AbstractZombie flagZombie = new FlagZombie();

        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
        System.out.println("---------------");

        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
    }
}

// 第一版

// 步骤1：抽象类
abstract class AbstractZombie{

    public abstract void display();

    public void attack(){
        System.out.println("咬");
    }

    public void move(){
        System.out.println("一步一步移动");
    }
}

// 步骤2：定义具体的策略角色，普通僵尸
class NormalZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是普通僵尸");
    }
}

// 步骤3：定义具体的策略角色，旗手僵尸
class FlagZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是旗手僵尸");
    }
}

// 第二版
// 步骤1：定义具体的策略角色，大头僵尸
class BigZombie extends AbstractZombie {
    @Override
    public void display() {
        System.out.println("我是大头僵尸");
    }

    @Override
    public void attack() {
        System.out.println("头撞");
    }
}

// 步骤2：定义具体的策略角色，石膏僵尸
class GypsumZombie extends AbstractZombie{

    @Override
    public void display() {
        System.out.println("我是石膏僵尸");
    }

    @Override
    public void move() {
        System.out.println("一瘸一拐");
    }

    @Override
    public void attack() {
        System.out.println("武器");
    }
}