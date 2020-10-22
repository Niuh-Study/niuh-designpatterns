package com.niuh.designpattern.facade;

/**
 * 外观/门面模式
 */
public class FacadePattern {

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.MethodA();
        facade.MethodB();
        System.out.println("----over----");
    }
}

class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        this.one = new SubSystemOne();
        this.two = new SubSystemTwo();
        this.three = new SubSystemThree();
        this.four = new SubSystemFour();
    }

    public void MethodA() {
        System.out.println("方法组A()----");
        one.methodOne();
        two.methodTwo();
        four.methodFour();
    }

    public void MethodB() {
        System.out.println("方法组B()----");
        two.methodTwo();
        three.methodThree();
    }
}

class SubSystemOne {
    public void methodOne() {
        System.out.println("子系统方法一");
    }
}

class SubSystemTwo {
    public void methodTwo() {
        System.out.println("子系统方法二");
    }
}

class SubSystemThree {
    public void methodThree() {
        System.out.println("子系统方法三");
    }
}

class SubSystemFour {
    public void methodFour() {
        System.out.println("子系统方法四");
    }
}


