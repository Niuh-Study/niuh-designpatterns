package com.niuh.designpattern.adapter.v2;

/**
 * 对象适配器模式
 */
public class AdapterPattern {
    public static void main(String[] args) {
        // 步骤4：定义具体使用目标类，并通过Adapter类调用所需要的方法从而实现目标
        //需要先创建一个被适配类的对象作为参数
        Target mAdapter = new Adapter(new Adaptee());
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

    public void SpecificOpertaion(){
    }
}

// 步骤3： 创建适配器类（Adapter）（不适用继承而是委派）
class Adapter implements Target{
    // 直接关联被适配类
    private Adaptee adaptee;

    // 可以通过构造函数传入具体需要适配的被适配类对象
    public Adapter (Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void operation() {
        // 这里是使用委托的方式完成特殊功能
        this.adaptee.SpecificOpertaion();
    }
}
