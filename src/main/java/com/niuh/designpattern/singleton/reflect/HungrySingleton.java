package com.niuh.designpattern.singleton.reflect;

/**
 * 饿汉模式防止反射攻击
 */
public class HungrySingleton {
    private static final HungrySingleton instance;

    private HungrySingleton(){
        if (instance != null) {
            throw new RuntimeException("单例模式私有构造器禁止反射调用！");
        }
    }

    static {
        instance = new HungrySingleton();
    }


    public static HungrySingleton getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}

