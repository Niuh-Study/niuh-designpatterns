package com.niuh.designpattern.abstractfactory;


/**
 * 抽象工厂模式
 */
public class AbstractFactoryPattern {
    // 步骤6：客户端通过实例化具体的工厂类，并调用其创建不同目标产品的方法创建不同具体产品类的实例
    public static void main(String[] args){
        FactoryA mFactoryA = new FactoryA();
        FactoryB mFactoryB = new FactoryB();
        //A厂当地客户需要容器产品A
        mFactoryA.ManufactureContainer().method1();
        //A厂当地客户需要模具产品A
        mFactoryA.ManufactureMould().method1();

        //B厂当地客户需要容器产品B
        mFactoryB.ManufactureContainer().method1();
        //B厂当地客户需要模具产品B
        mFactoryB.ManufactureMould().method1();

    }
}

// 步骤1： 创建抽象工厂类，定义具体工厂的公共接口
abstract class Factory{
    public abstract AbstractProduct ManufactureContainer();
    public abstract AbstractProduct ManufactureMould();
}

// 步骤2： 创建抽象产品族类 ，定义具体产品的公共接口；
abstract class AbstractProduct{
    public abstract void method1();
}

// 步骤3： 创建抽象产品类 ，定义具体产品的公共接口；
//容器产品抽象类
abstract class ContainerProduct extends AbstractProduct {
    @Override
    public abstract void method1();
}

//模具产品抽象类
abstract class MouldProduct extends AbstractProduct {
    @Override
    public abstract void method1();
}

// 步骤4： 创建具体产品类（继承抽象产品类）， 定义生产的具体产品；
//容器产品A类
class ContainerProductA extends ContainerProduct{
    @Override
    public void method1() {
        System.out.println("生产出了容器产品A");
    }
}

//容器产品B类
class ContainerProductB extends ContainerProduct{
    @Override
    public void method1() {
        System.out.println("生产出了容器产品B");
    }
}

//模具产品A类
class MouldProductA extends MouldProduct{

    @Override
    public void method1() {
        System.out.println("生产出了模具产品A");
    }
}

//模具产品B类
class MouldProductB extends MouldProduct{

    @Override
    public void method1() {
        System.out.println("生产出了模具产品B");
    }
}

// 步骤5：创建具体工厂类（继承抽象工厂类），定义创建对应具体产品实例的方法；
//A厂 - 生产模具+容器产品
class FactoryA extends Factory{

    @Override
    public AbstractProduct ManufactureContainer() {
        return new ContainerProductA();
    }

    @Override
    public AbstractProduct ManufactureMould() {
        return new MouldProductA();
    }
}

//B厂 - 生产模具+容器产品
class FactoryB extends Factory{

    @Override
    public AbstractProduct ManufactureContainer() {
        return new ContainerProductB();
    }

    @Override
    public AbstractProduct ManufactureMould() {
        return new MouldProductB();
    }
}
