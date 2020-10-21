package com.niuh.designpattern.prototype;

import java.io.Serializable;

/**
 * 基础类
 */
public class BaseInfo implements Cloneable , Serializable {

    private String desc;

    // .......


    public BaseInfo(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "desc=" + desc +
                '}';
    }

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        //BaseInfo 如果也有引用类型的成员属性，也应该和 User 类一样实现
        return (BaseInfo) super.clone();
    }
}
