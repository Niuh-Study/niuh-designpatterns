package com.niuh.designpattern.singleton.v5;

/**
 * 懒汉式（线程安全，同步代码块）
 */
public class Singleton {private static Singleton instance;

    // 构造函数私有化
    private Singleton() {

    }
    // 提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}

class SingletonTest05 {
    public static void main(String[] args) {
        // 测试
        for (int i = 0; i< 100; i++) {
            new Thread(() ->
                    System.out.println(com.niuh.designpattern.singleton.v3.Singleton.getInstance().hashCode())
            ).start();
        }
    }
}