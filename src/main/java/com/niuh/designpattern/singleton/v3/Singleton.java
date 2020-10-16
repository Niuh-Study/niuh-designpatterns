package com.niuh.designpattern.singleton.v3;

/**
 *
 * 懒汉式（线程不安全）
 */
public class Singleton {
    private static Singleton instance;

    // 构造函数私有化
    private Singleton() {

    }

    // 提供一个静态的公共方法，当使用到该方法时，才创建 instance，即懒汉式
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonTest03 {
    public static void main(String[] args) {
        // 测试
        for (int i = 0; i< 100; i++) {
            new Thread(() ->
                    System.out.println(Singleton.getInstance().hashCode())
            ).start();
        }
    }
}
