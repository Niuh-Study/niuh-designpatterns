package com.niuh.designpattern.bridge.v2;

/**
 * 桥接模式案例
 */
public class BridgePattern {

    public static void main(String[] args) {
        //实现化和抽象化分离

        // 基本报表
        IReport basicReport = new BasicReport();
        // 往来报表
        IReport intercourseReport = new IntercourseReport();
        // 资金报表
        IReport capitalReport = new CapitalReport();

        // 基本报表使用柱状图
        AbstractionGraph barchart = new Barchart(basicReport);
        barchart.operation();

        // 基本报表使用饼图
        AbstractionGraph piechart = new Piechart(basicReport);
        piechart.operation();
    }

}


// 步骤1：定义实现化角色，报表接口
interface IReport {
    void operationImpl();
}

// 步骤2：定义具体实现化角色（基本报表、往来报表、资金报表）
class BasicReport implements IReport {

    @Override
    public void operationImpl() {
        System.out.println("基本报表被访问.");
    }
}

class IntercourseReport implements IReport {

    @Override
    public void operationImpl() {
        System.out.println("往来报表被访问.");
    }
}

class CapitalReport implements IReport {

    @Override
    public void operationImpl() {
        System.out.println("资金报表被访问.");
    }
}

// 步骤3：定义抽象化角色，图形
abstract class AbstractionGraph {
    protected IReport iReport;

    public AbstractionGraph(IReport iReport) {
        this.iReport = iReport;
    }

    abstract void operation();
}

// 步骤4：定义扩展抽象化角色（柱状图、饼图）
class Barchart extends AbstractionGraph {

    public Barchart(IReport iReport) {
        super(iReport);
    }

    @Override
    void operation() {
        System.out.println("柱状图被访问.");
        iReport.operationImpl();
    }
}

class Piechart extends AbstractionGraph {

    public Piechart(IReport iReport) {
        super(iReport);
    }

    @Override
    void operation() {
        System.out.println("饼图被访问.");
        iReport.operationImpl();
    }
}

