package com.niuh.designpattern.singleton.v7;

/**
 * 静态内部类完成，推荐使用
 */
public class Singleton {

    // 添加 volatile 关键字，防止指令重排
    private static volatile Singleton instance;

    // 构造函数私有化
    private Singleton() {

    }

    // 写一个静态内部类，该类中有一个静态属性 Singleton
    private static class SingletonInstance {
        private  static final Singleton INSTANCE = new Singleton();
    }

    // 提供一个静态的公有方法，直接返回 SingletonInstance.INSTANCE
    public static synchronized Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
