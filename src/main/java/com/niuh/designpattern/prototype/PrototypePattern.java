package com.niuh.designpattern.prototype;


/**
 * 原型设计模式
 */
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {

        BaseInfo baseInfo = new BaseInfo("张三");

        User user1 = new User(1, "张三", "男", "123456", baseInfo);

        // new User  ......

        // 克隆机制
        User user2 = user1.clone();
        user2.setId(2);
        user2.setName("李四");
        BaseInfo baseInfo1 = user2.getBaseInfo();
        baseInfo1.setDesc("李四");


        System.out.println(user1);
        System.out.println(user2);

    }
}
