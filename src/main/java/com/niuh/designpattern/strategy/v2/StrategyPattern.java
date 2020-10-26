package com.niuh.designpattern.strategy.v2;


/**
 * 策略模式
 */
public class StrategyPattern {
    public static void main(String[] args) {
        // 普通僵尸
        NormalZombie normalZombie = new NormalZombie(new StepByStepMove(), new BiteAttack());
        normalZombie.display();
        normalZombie.move();
        normalZombie.attack();
        System.out.println("-----------");
        // 旗手僵尸
        FlagZombie flagZombie = new FlagZombie(new StepByStepMove(), new BiteAttack());
        flagZombie.display();
        flagZombie.move();
        flagZombie.attack();
        System.out.println("-----------");
        // 大头僵尸
        BigZombie bigZombie = new BigZombie(new StepByStepMove(), new HeadAttack());
        bigZombie.display();
        bigZombie.move();
        bigZombie.attack();
        System.out.println("-----------");
        // 石膏僵尸
        GypsumZombie gypsumZombie = new GypsumZombie(new LameMove(), new BiteAttack());
        gypsumZombie.display();
        gypsumZombie.move();
        //如果石膏僵尸遇到了第一个植物
        System.out.println("我遇到了第一个植物");
        gypsumZombie.setAttackBehavior(new ArmsAttack());
        gypsumZombie.move();
        gypsumZombie.attack();
    }
}

// 步骤1：定义移动行为接口
interface MoveBehavior {
    void move();
}

// 步骤2：定义攻击行为接口
interface AttackBehavior {
    void attack();
}


// 步骤3：定义抽象策略角色，抽象类
abstract class AbstractZombie {
    MoveBehavior moveBehavior;
    AttackBehavior attackBehavior;

    public AbstractZombie(MoveBehavior moveBehavior, AttackBehavior attackBehavior) {
        this.moveBehavior = moveBehavior;
        this.attackBehavior = attackBehavior;
    }

    abstract void display();

    void move() {
        moveBehavior.move();
    }

    void attack() {
        attackBehavior.attack();
    }

    public AttackBehavior getAttackBehavior() {
        return attackBehavior;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }
}

// 步骤4：各种僵尸子类
class NormalZombie extends AbstractZombie {
    public NormalZombie(MoveBehavior moveBehavior, AttackBehavior attackBehavior) {
        super(moveBehavior, attackBehavior);
    }

    @Override
    void display() {
        System.out.println("我是普通僵尸");
    }
}

class FlagZombie extends AbstractZombie {
    public FlagZombie(MoveBehavior moveBehavior, AttackBehavior attackBehavior) {
        super(moveBehavior, attackBehavior);
    }

    @Override
    void display() {
        System.out.println("我是旗手僵尸");
    }
}

class BigZombie extends AbstractZombie {
    public BigZombie(MoveBehavior moveBehavior, AttackBehavior attackBehavior) {
        super(moveBehavior, attackBehavior);
    }

    @Override
    void display() {
        System.out.println("我是大头僵尸");
    }
}

class GypsumZombie extends AbstractZombie {
    public GypsumZombie(MoveBehavior moveBehavior, AttackBehavior attackBehavior) {
        super(moveBehavior, attackBehavior);
    }

    @Override
    void display() {
        System.out.println("我是石膏僵尸");
    }
}

// 步骤5：定义移动行为子类
class StepByStepMove implements MoveBehavior {
    @Override
    public void move() {
        System.out.println("一步一步移动");
    }
}

class LameMove implements MoveBehavior {
    @Override
    public void move() {
        System.out.println("一瘸一拐");
    }
}

// 步骤6：定义攻击行为子类
class BiteAttack implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("咬");
    }
}
class HeadAttack implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("头撞");
    }
}
class ArmsAttack implements AttackBehavior{
    @Override
    public void attack() {
        System.out.println("武器");
    }
}
