package com.niuh.designpattern.memento.v2;

/**
 * <p>
 * 备忘录模式案例
 * </p>
 */
public class MementoPattern {

    // 逻辑大致为打boss前存档，打boss失败了
    public static void main(String[] args) {
        //打boss前
        GameRole gameRole = new GameRole();
        gameRole.getInitState();
        gameRole.stateDisplay();

        //保存进度
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        caretaker.setMemento(gameRole.saveState());

        //打boss失败
        gameRole.fight();
        gameRole.stateDisplay();

        //恢复状态
        gameRole.recoveryState(caretaker.getMemento());
        gameRole.stateDisplay();
    }
}


// 步骤1：定义备忘录角色，用于存储角色状态。
class RoleStateMemento {

    private int vit;    //生命力
    private int atk;    //攻击力
    private int def;    //防御力

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }
}

// 步骤2：定义发起人角色（当前游戏角色），记录当前游戏角色的生命力、攻击力、防御力。通过saveState()方法来保存当前状态，通过recoveryState()方法来恢复角色状态。
class GameRole {

    private int vit;    //生命力
    private int atk;    //攻击力
    private int def;    //防御力

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    //状态显示
    public void stateDisplay() {
        System.out.println("角色当前状态：");
        System.out.println("体力：" + this.vit);
        System.out.println("攻击力：" + this.atk);
        System.out.println("防御力： " + this.def);
        System.out.println("-----------------");
    }

    //获得初始状态
    public void getInitState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    //战斗后
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    //保存角色状态
    public RoleStateMemento saveState() {
        return (new RoleStateMemento(vit, atk, def));
    }

    //恢复角色状态
    public void recoveryState(RoleStateMemento memento) {
        this.vit = memento.getVit();
        this.atk = memento.getAtk();
        this.def = memento.getDef();
    }
}

// 步骤3：定义管理者角色，角色状态管理者
class RoleStateCaretaker {

    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }

}
