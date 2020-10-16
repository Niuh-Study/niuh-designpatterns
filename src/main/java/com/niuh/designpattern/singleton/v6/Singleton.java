package com.niuh.designpattern.singleton.v6;

/**
 * 双重检查 DCL
 */
public class Singleton {

    // 添加 volatile 关键字，防止指令重排
    private static volatile Singleton instance;

    // 构造函数私有化
    private Singleton() {

    }

    // 提供对外引用的静态方法，使用双重检查机制 double check
    public static Singleton getInstance() {
        if (instance == null) { // Double Check Lock
            // 双重检查
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
