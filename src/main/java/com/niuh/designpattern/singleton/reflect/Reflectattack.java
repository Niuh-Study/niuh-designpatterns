package com.niuh.designpattern.singleton.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 反射攻击实例
 */
public class Reflectattack {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);

        HungrySingleton hungrySingleton = declaredConstructor.newInstance();

        HungrySingleton instance = HungrySingleton.getInstance();

        System.out.println(hungrySingleton);
        System.out.println(instance);
        System.out.println(hungrySingleton == instance);
    }
}
