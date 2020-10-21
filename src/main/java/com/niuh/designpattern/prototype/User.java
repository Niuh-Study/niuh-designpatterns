package com.niuh.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * 用户信息
 */
public class User implements Cloneable , Serializable {

    // 基础数据类型
    private int id;
    private String name;
    private String sex;
    private String pwd;

    // 引用数据类型
    private BaseInfo baseInfo;

    public User(int id, String name, String sex, String pwd, BaseInfo baseInfo) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.pwd = pwd;
        this.baseInfo = baseInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "hashCode: " + super.hashCode() + ", User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", pwd='" + pwd + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }

    @Override
    protected User clone() throws CloneNotSupportedException {
        // 深拷贝
        // User user = (User) super.clone();
        // user.baseInfo = baseInfo.clone();
        // return user;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try (ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream)) {

            oos.writeObject(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());

        try (ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream)) {
            try {
                User user = (User) ois.readObject();
                return user;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
