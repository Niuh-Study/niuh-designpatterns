package com.niuh.designpattern.singleton.v1;

/**
 *  饿汉模式（静态变量）
 *  类加载到内存后，就实例化一个单例。JVM保证线程安全
 *  简单使用，推荐使用
 *  唯一缺点：不管用到与否，类装载时就完成实例化
 *  Class.forName("")
 *     (话说你不用的，你装载它干啥)
 */
public class Singleton {

    // 1. 构造器私有化（防止new）
    private Singleton () {

    }
    // 2. 本类内部创建对象
    private final static Singleton instance = new Singleton();

    // 3. 提供一个公有的静态方法，返回实例对象，提供给外部使用
    public static Singleton getInstance() {
        return instance;
    }


}

class SingletonTest01 {
    public static void main(String[] args) {
        // 测试
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2); // true

        System.out.println("instance1.hashCode=" + instance1.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());
    }
}