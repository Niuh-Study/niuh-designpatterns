package com.niuh.designpattern.factorymethod.v2;


/**
 * 工厂方法模式
 */
public class FactoryPattern {

    // 步骤5：外界通过调用具体工厂类的方法，从而创建不同具体产品类的实例
    public static void main(String[] args) {
        //客户要产品A
        FactoryA mFactoryA = new FactoryA();
        mFactoryA.Manufacture().method1();

        //客户要产品B
        FactoryB mFactoryB = new FactoryB();
        mFactoryB.Manufacture().method1();
    }

}

// 步骤1： 创建抽象工厂类，定义具体工厂的公共接口
abstract class Factory {
    public abstract Product Manufacture();
}

// 步骤2： 创建抽象产品类 ，定义具体产品的公共接口；
abstract class Product {
    public abstract void method1();
}

// 步骤3： 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
//具体产品A类
class ProductA extends Product {
    @Override
    public void method1() {
        System.out.println("生产出了产品A");
    }
}

//具体产品B类
class ProductB extends Product {

    @Override
    public void method1() {
        System.out.println("生产出了产品B");
    }
}

// 步骤4：创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法；
//工厂A类 - 生产A类产品
class FactoryA extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

//工厂B类 - 生产B类产品
class FactoryB extends Factory {
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}