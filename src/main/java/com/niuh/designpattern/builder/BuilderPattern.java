package com.niuh.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 */
public class BuilderPattern<builder> {

    public static void main(String[] args) {
        // 步骤5：客户端调用-小张到电脑城找老板买电脑

        //逛了很久终于发现一家合适的电脑店
        //找到该店的老板和装机人员
        Director director = new Director();

        Builder builder = new ConcreteBuilder();

        //沟通需求后，老板叫装机人员去装电脑
        director.Construct(builder);

        //装完后，组装人员搬来组装好的电脑
        Computer computer = builder.GetComputer();
        //组装人员展示电脑给小张看
        computer.Show();
    }
}


// 步骤1：定义具体产品类（Product）：电脑
class Computer {

    //电脑组件的集合
    private List<String> parts = new ArrayList<String>();

    //用于将组件组装到电脑里
    public void Add(String part) {
        parts.add(part);
    }

    public void Show() {
        for (int i = 0; i < parts.size(); i++) {
            System.out.println("组件" + parts.get(i) + "装好了");
        }
        System.out.println("电脑组装完成，请验收");
    }

}

// 步骤2：定义组装的过程（Builder）：组装电脑的过程
abstract class Builder {

    //第一步：装CPU
    //声明为抽象方法，具体由子类实现
    public abstract void BuildCPU();

    //第二步：装主板
    //声明为抽象方法，具体由子类实现
    public abstract void BuildMainboard();

    //第三步：装硬盘
    //声明为抽象方法，具体由子类实现
    public abstract void BuildHD();

    //返回产品的方法：获得组装好的电脑
    public abstract Computer GetComputer();
}

// 步骤3： 中关村老板委派任务给装机人员（Director）
class Director {
    //指挥装机人员组装电脑
    public void Construct(Builder builder) {
        builder.BuildCPU();
        builder.BuildMainboard();
        builder.BuildHD();
    }
}

// 步骤4： 创建具体的建造者（ConcreteBuilder）:装机人员
//装机人员1
class ConcreteBuilder extends Builder {
    //创建产品实例
    Computer computer = new Computer();

    //组装产品
    @Override
    public void BuildCPU() {
        computer.Add("CPU");
    }

    @Override
    public void BuildMainboard() {
        computer.Add("主板");
    }

    @Override
    public void BuildHD() {
        computer.Add("硬盘");
    }

    //返回组装成功的电脑
    @Override
    public Computer GetComputer() {
        return computer;
    }
}


