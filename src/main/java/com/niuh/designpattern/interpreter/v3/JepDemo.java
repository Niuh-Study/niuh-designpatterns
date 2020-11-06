package com.niuh.designpattern.interpreter.v3;


import org.nfunk.jep.JEP;

/**
 * <p>
 * JepDemo
 * </p>
 */
public class JepDemo {

    public static void main(String[] args) {
        JEP jep = new JEP(); //一个数学表达式
        String exp = "((a+b)*(c+b))/(c+a)/b"; //给变量赋值
        jep.addVariable("a", 10);
        jep.addVariable("b", 10);
        jep.addVariable("c", 10);
        try { //执行
            jep.parseExpression(exp);
            Object result = jep.getValueAsObject();
            System.out.println("计算结果： " + result);
        } catch (Throwable e) {
            System.out.println("An error occured: " + e.getMessage());
        }

    }
}
