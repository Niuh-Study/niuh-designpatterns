package com.niuh.designpattern.adapter.v1;

/**
 * 类适配器模式
 */
public class AdapterPattern {

    // 步骤4：定义具体使用目标类，并通过Adapter类调用所需要的方法从而实现目标
    public static void main(String[] args) {

        Target mAdapter = new Adapter();
        mAdapter.operation();

    }
}

// 步骤1： 创建Target接口
interface Target {

    //这是源类Adapteee没有的方法
    void operation();
}

// 步骤2： 创建源类（Adaptee）
class Adaptee {

    public void SpecificOperation() {

    }
}

// 步骤3： 创建适配器类（Adapter）
//适配器Adapter继承自Adaptee，同时又实现了目标(Target)接口。
class Adapter extends Adaptee implements Target {

    //目标接口要求调用operation()这个方法名，但源类Adaptee没有方法operation()
    //因此适配器补充上这个方法名
    //但实际上operation()只是调用源类Adaptee的SpecificOpertaion()方法的内容
    //所以适配器只是将SpecificOpertaion()方法作了一层封装，封装成Target可以调用的operation()而已
    @Override
    public void operation() {
        this.SpecificOperation();
    }

}

