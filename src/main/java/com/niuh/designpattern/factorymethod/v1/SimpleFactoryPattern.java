package com.niuh.designpattern.factorymethod.v1;

/**
 * 简单工厂模式
 */
public class SimpleFactoryPattern {

    // 步骤4. 外界通过调用工厂类的静态方法，传入不同参数从而创建不同具体产品类的实例
    public static void main(String[] args) {
        Factory mFactory = new Factory();
        //客户要产品A
        try {
            //调用工厂类的静态方法 & 传入不同参数从而创建产品实例
            mFactory.Manufacture("A").method1();
        } catch (NullPointerException e) {
            System.out.println("没有这一类产品");
        }

        //客户要产品B
        try {
            mFactory.Manufacture("B").method1();
        } catch (NullPointerException e) {
            System.out.println("没有这一类产品");
        }

        //客户要产品C
        try {
            mFactory.Manufacture("C").method1();
        } catch (NullPointerException e) {
            System.out.println("没有这一类产品");
        }

        //客户要产品D
        try {
            mFactory.Manufacture("D").method1();
        } catch (NullPointerException e) {
            System.out.println("没有这一类产品");
        }
    }

}

// 步骤1. 创建抽象产品类，定义具体产品的公共接口
abstract class Product {
    public abstract void method1();
}

// 步骤2. 创建具体产品类（继承抽象产品类），定义生产的具体产品
//具体产品类A
class ProductA extends Product {
    @Override
    public void method1() {
        System.out.println("生产出了产品A");
    }
}

//具体产品类B
class ProductB extends Product {
    @Override
    public void method1() {
        System.out.println("生产出了产品C");
    }
}

//具体产品类C
class ProductC extends Product {
    @Override
    public void method1() {
        System.out.println("生产出了产品C");
    }
}

// 步骤3. 创建工厂类，通过创建静态方法从而根据传入不同参数创建不同具体产品类的实例
class Factory {
    public Product Manufacture(String ProductName) {
        //工厂类里用switch语句控制生产哪种商品；
        //使用者只需要调用工厂类的静态方法就可以实现产品类的实例化。
        switch (ProductName) {
            case "A":
                return new ProductA();
            case "B":
                return new ProductB();
            case "C":
                return new ProductC();
            default:
                return null;
        }
    }
}

