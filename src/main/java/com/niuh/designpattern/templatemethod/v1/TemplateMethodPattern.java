package com.niuh.designpattern.templatemethod.v1;

/**
 * 模版方法模式
 */
public class TemplateMethodPattern {
    public static void main(String[] args) {
        AbstractClass tm = new ConcreteClass();
        tm.templateMethod();
    }
}

//抽象类
abstract class AbstractClass {

    //模板方法
    public void templateMethod() {
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    //具体方法
    public void specificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();
}

//具体子类
class ConcreteClass extends AbstractClass {

    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
