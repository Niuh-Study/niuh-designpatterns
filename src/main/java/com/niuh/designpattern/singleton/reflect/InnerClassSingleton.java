package com.niuh.designpattern.singleton.reflect;

/**
 * 静态内部类防止反射破坏
 */
public class InnerClassSingleton {

    // 添加 volatile 关键字，防止指令重排
    private static volatile InnerClassSingleton instance;

    // 构造函数私有化
    private InnerClassSingleton() {

    }

    // 写一个静态内部类，该类中有一个静态属性 Singleton
    private static class InnerClassHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    // 提供一个静态的公有方法，直接返回 SingletonInstance.INSTANCE
    public static synchronized InnerClassSingleton getInstance() {
        return InnerClassHolder.INSTANCE;
    }
}
