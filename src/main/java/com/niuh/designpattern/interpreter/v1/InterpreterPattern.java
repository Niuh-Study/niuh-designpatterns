package com.niuh.designpattern.interpreter.v1;

/**
 * <p>
 * 解释器模式
 * </p>
 */
public class InterpreterPattern {
}

//抽象表达式类
interface AbstractExpression {
    public Object interpret(String info);    //解释方法
}

//终结符表达式类
class TerminalExpression implements AbstractExpression {
    public Object interpret(String info) {
        //对终结符表达式的处理
        return null;
    }
}

//非终结符表达式类
class NonterminalExpression implements AbstractExpression {
    private AbstractExpression exp1;
    private AbstractExpression exp2;

    public Object interpret(String info) {
        //非对终结符表达式的处理
        return null;
    }
}

//环境类
class Context {
    private AbstractExpression exp;

    public Context() {
        //数据初始化
    }

    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}