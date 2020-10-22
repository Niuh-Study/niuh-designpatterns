package com.niuh.designpattern.flyweight;

import java.util.HashMap;

/**
 * 享元模式
 */
public class FlyweightPattern {
    public static void main(String[] args) {

        Flyweight flyweight1 = FlyweightFactory.getFlyweight("1");
        Flyweight flyweight2 = FlyweightFactory.getFlyweight("1");
        Flyweight flyweight3 = FlyweightFactory.getFlyweight("2");


        Integer a = Integer.valueOf(127);
        Integer b = new Integer(127);
        System.out.println(a == b);
        int c = 127;
        System.out.println(a == c);
        System.out.println(b == c);

    }
}

// 步骤1：抽象享元角色，定义一个对象的外部状态和内部状态的接口或实现的抽象类。

abstract class Flyweight {

    //内部状态
    private String intrinsic;
    //外部状态
    protected  final String Extrinsic;

    //要求享元角色必须接受外部状态
    public Flyweight(String _Extrinsic){
        System.out.println(" Extrinsic: "+ _Extrinsic +" created. ");
        this.Extrinsic=_Extrinsic;
    }

    //定义业务操作
    public abstract void operate();

    //内部状态的getter/setter
    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}

// 步骤2：具体享元角色，定义具体的一个产品类，需要注意的是内部状态处理应该与环境无关，不应该出现一个操作改变了外部状态，同时也改变了内部状态。
class ConcreteFlyweight extends Flyweight {

    //接受外部状态
    public ConcreteFlyweight(String _Extrinsic){
        super(_Extrinsic);
    }

    //根据外部状态进行逻辑处理
    @Override
    public void operate() {
        //业务逻辑
    }
}

// 步骤3：享元工厂，构造一个池容器，提供从池中获得对象的方法。
class FlyweightFactory {
    //定义一个池容器
    private static HashMap<String,Flyweight> pool=new HashMap<>();
    //享元工厂
    public static Flyweight getFlyweight(String Extrinsic){
        //需要返回的对象
        Flyweight flyweight=null;
        //如果在池中有该对象,直接从池中拿
        if (pool.containsKey(Extrinsic)){
            flyweight=pool.get(Extrinsic);
        }else { //如果池中没有该对象，则创建一个并放入池中
            flyweight=new ConcreteFlyweight(Extrinsic);
            pool.put(Extrinsic,flyweight);
        }
        return flyweight;
    }
}
