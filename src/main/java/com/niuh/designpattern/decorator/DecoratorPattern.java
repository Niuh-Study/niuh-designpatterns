package com.niuh.designpattern.decorator;

import java.io.DataInputStream;
import java.io.FilterInputStream;

/**
 * 装饰模式
 */
public class DecoratorPattern {

    // 步骤6：给不同的用户在视频直播的时候添加不同的功能
    public static void main(String[] args) {
        // 添加美颜
        Component componentA  = new ConcreteDecoratorA(new ConcreteComponent());
        componentA.operation();

        System.out.println();

        // 添加滤镜
        Component componentB  = new ConcreteDecoratorB(new ConcreteComponent());
        componentB.operation();

        System.out.println();

        // 添加美颜和滤镜
        Component component  = new ConcreteDecoratorA(new ConcreteDecoratorB(new ConcreteComponent()));
        component.operation();
    }

}

// 步骤1：定义Component抽象构件，也就是定义视频软件基础接口
abstract class Component {
    //抽象的方法
    public abstract void operation();
}

// 步骤2：定义ConcreteComponent具体构件，也就是实现一个视频软件的基本功能
class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("视频软件直播.");
    }
}

// 步骤3：定义Decorator装饰角色，是抽象类，聚合了Component接口
//抽象装饰者
abstract class Decorator extends Component {
    private Component component=null;

    //通过构造函数传递被修饰者
    public Decorator(Component component){
        this.component=component;
    }

    //委托给被修饰者执行
    @Override
    public void operation() {
        this.component.operation();
    }
}

// 步骤4：具体装饰角色，A用户需要添加美颜功能
class ConcreteDecoratorA extends Decorator {

    //定义被修饰者
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void decorator(){
        System.out.println("添加美颜.");
    }

    @Override
    public void operation() {
        this.decorator();
        super.operation();
    }
}

// 步骤5：具体装饰角色，B用户需要添加滤镜功能
class ConcreteDecoratorB extends Decorator {

    //定义被修饰者
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void decorator(){
        System.out.println("添加滤镜.");
    }

    @Override
    public void operation() {
        this.decorator();
        super.operation();
    }
}






