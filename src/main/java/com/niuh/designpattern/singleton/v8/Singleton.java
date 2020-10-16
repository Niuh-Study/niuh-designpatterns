package com.niuh.designpattern.singleton.v8;

/**
 * 使用枚举，可以实现单例, 推荐
 */
public enum Singleton {
    INSTANCE; // 属性

    public void hello() {
        System.out.println("hello word~");
    }

}

 class SingletonTest08 {
    public static void main(String[] args) {

        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;

        System.out.println(instance1 == instance2);

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        instance1.hello();
    }
}
