package com.niuh.designpattern.adapter.v3;

import java.util.Arrays;

/**
 * 类适配器模式-案例
 */
public class AdapterPattern {

    public static void main(String[] args) {
        Target mAdapter220V = new Adapter220V();
        ImportedMachine mImportedMachine = new ImportedMachine();

        //用户拿着进口机器插上适配器（调用Convert_110v()方法）
        //再将适配器插上原有插头（Convert_110v()方法内部调用Output_220v()方法输出220V）
        //适配器只是个外壳，对外提供110V，但本质还是220V进行供电
        mAdapter220V.convert_110v();
        mImportedMachine.Work();
    }
}

//进口机器类
class ImportedMachine {


    public void Work() {
        System.out.println("进口电视正常运行");
    }
}

// 步骤1： 创建Target接口（期待得到的插头）：能输出110V（将220V转换成110V）
interface Target {

    //将220V转换输出110V（原有插头（Adaptee）没有的）
    void convert_110v();
}

// 步骤2： 创建源类（原有的插头）
class PowerPort220V{
    //原有插头只能输出220V
    public void output_220v(){
    }
}

// 步骤3：创建适配器类（Adapter）
class Adapter220V extends PowerPort220V implements Target{
    //期待的插头要求调用convert_110v()，但原有插头没有
    //因此适配器补充上这个方法名
    //但实际上convert_110v()只是调用原有插头的output_220v()方法的内容
    //所以适配器只是将output_220v()作了一层封装，封装成Target可以调用的convert_110v()而已

    @Override
    public void convert_110v(){
        this.output_220v();
    }
}

