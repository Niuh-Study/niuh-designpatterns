package com.niuh.designpattern.composite.v2;

import java.util.ArrayList;

/**
 * 组合模式
 * <p>
 * 用组合模式实现当用户在商店购物后，显示其所选商品信息，并计算所选商品总价的功能
 */
public class CompositePattern {

    public static void main(String[] args) {
        float s = 0;
        Bags BigBag, mediumBag, smallRedBag, smallWhiteBag;
        Goods sp;
        BigBag = new Bags("大袋子");
        mediumBag = new Bags("中袋子");
        smallRedBag = new Bags("红色小袋子");
        smallWhiteBag = new Bags("白色小袋子");
        sp = new Goods("南京特产", 2, 7.9f);
        smallRedBag.add(sp);
        sp = new Goods("南京地图", 1, 9.9f);
        smallRedBag.add(sp);
        sp = new Goods("香菇", 2, 68);
        smallWhiteBag.add(sp);
        sp = new Goods("红茶", 3, 180);
        smallWhiteBag.add(sp);
        sp = new Goods("雨花石吊坠", 1, 380);
        mediumBag.add(sp);
        mediumBag.add(smallRedBag);
        sp = new Goods("李宁牌运动鞋", 1, 198);
        BigBag.add(sp);
        BigBag.add(smallWhiteBag);
        BigBag.add(mediumBag);
        System.out.println("隔壁老王选购的商品有：");
        BigBag.show();
        s = BigBag.calculation();
        System.out.println("要支付的总价是：" + s + "元");

    }
}

//步骤1：定义抽象构件（Component）角色：物品
interface Articles {
    float calculation(); //计算

    void show();
}

//步骤2：定义树叶构件（Leaf）角色：商品
class Goods implements Articles {
    private String name;     //名字
    private int quantity;    //数量
    private float unitPrice; //单价

    public Goods(String name, int quantity, float unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public float calculation() {
        return quantity * unitPrice;
    }

    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + unitPrice + "元)");
    }
}

// 步骤3：定义树枝构件（Composite）角色：袋子
class Bags implements Articles {
    private String name;     //名字
    private ArrayList<Articles> bags = new ArrayList<Articles>();

    public Bags(String name) {
        this.name = name;
    }

    public void add(Articles c) {
        bags.add(c);
    }

    public void remove(Articles c) {
        bags.remove(c);
    }

    public Articles getChild(int i) {
        return bags.get(i);
    }

    public float calculation() {
        float s = 0;
        for (Object obj : bags) {
            s += ((Articles) obj).calculation();
        }
        return s;
    }

    public void show() {
        for (Object obj : bags) {
            ((Articles) obj).show();
        }
    }
}