package com.niuh.designpattern.proxy.v3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <p>
 * CGLIB动态代理
 * </p>
 */
public class CglibProxy {

    public static void main(String[] args) {
        WorkImplProxyLib cglib = new WorkImplProxyLib();
        WorkImpl workCglib = (WorkImpl) cglib.getWorkProxyImplInstance();
        workCglib.addWorkExperience();
    }
}

class WorkImpl {

    void addWorkExperience() {
        System.out.println("增加工作经验的普通方法...");
    }
}

class WorkImplProxyLib implements MethodInterceptor {

    // 创建代理对象
    Object getWorkProxyImplInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(WorkImpl.class);
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始...");
        methodProxy.invokeSuper(obj, args);
        System.out.println("结束...");
        return null;
    }
}
