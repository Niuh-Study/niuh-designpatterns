package com.niuh.designpattern.observer.v1;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * 观察者模式
 */
public class ObserverPattern {

    // 步骤6：开始上课，开始记录报告
    public static void main(String[] args) {
        // 创建学生主体
        StudentSubject studentSubject = new StudentSubject();

        // 创建观察者老师
        TeacherObserver teacherObversable = new TeacherObserver("王老师");

        // 创建观察者班主任
        HeadTeacherObserver headTeacherObserver = new HeadTeacherObserver("班主任");

        // 学生反映上课状态
        studentSubject.setState("讲的不错,很好!");
        studentSubject.addObservable(teacherObversable);
        studentSubject.addObservable(headTeacherObserver);

        // 开始上课
        studentSubject.doNotify();

        // 上课结束
        studentSubject.removeObservable(headTeacherObserver);
        studentSubject.removeObservable(teacherObversable);
    }
}

// 步骤1：构建一个课程实体类

/**
 * 课程类
 */
class Course {

    // 上课时间:time
    private Date time;
    // 上课地点:place
    private String place;
    // 上课内容:content
    private String content;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Course() {
    }

    public Course(Date time, String place, String content) {
        this.time = time;
        this.place = place;
        this.content = content;
    }
}


// 步骤2：构建一个发现者的抽象类以及相关的实现类，老师和班主任都分别继承了该接口并重写相关方法
abstract class Observer {
    abstract void update(Object args);

    public Observer(String identity) {
        this.identity = identity;
    }

    private String identity;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}


// 步骤3：创建一个具体的观察者角色，老师拿着教材开始来上课

/**
 * 老师类
 * - 观察者之一
 * - 观察学生的上课情况
 */
class TeacherObserver extends Observer {

    private Course course;

    @Override
    public void update(Object args) {
        DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println("我是王老师,正在讲课中...");

        course = new Course(new Date(), "A栋教学楼", "高等数学");
        System.out.println("今天上课时间:" + df.format(course.getTime()) + " 地点:" + course.getPlace() + " 上课内容:" + course.getContent());
    }

    public TeacherObserver(String identity) {
        super(identity);
    }
}

// 步骤4：创建一个具体的观察者角色，班主任来听课

/**
 * 班主任来听课
 * - 观察者之一
 * - 观察学生的上课情况
 */
class HeadTeacherObserver extends Observer {
    @Override
    public void update(Object args) {
        System.out.println("我是班主任来听课了,正在检查课程质量...");
        System.out.println("学生反馈课程质量为:" + args);
    }

    public HeadTeacherObserver(String identity) {
        super(identity);
    }
}

// 步骤5：创建被观察者主体，模拟学生的主体登场了

/**
 * 主体类
 * - 模拟被观察者主体
 */
abstract class Subject {
    /**
     * 修改通知
     */
    abstract void doNotify();

    /**
     * 添加被观察者
     */
    abstract void addObservable(Observer o);

    /**
     * 移除被观察者
     */
    abstract void removeObservable(Observer o);
}

// 步骤6：创建具体的被观察者主体角色，学生主体为被观察对象

/**
 * 学生主体
 * - 被观察的对象
 */
class StudentSubject extends Subject {
    /**
     * 上课状态
     */
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private List<Observer> observableList = new ArrayList<>();

    @Override
    public void doNotify() {
        for (Observer observer : observableList) {
            observer.update(state);
        }
    }

    @Override
    public void addObservable(Observer observable) {
        observableList.add(observable);
    }

    @Override
    public void removeObservable(Observer observable) {
        try {
            if (observable == null) {
                throw new Exception("要移除的被观察者不能为空");
            } else {
                if (observableList.contains(observable) ) {
                    System.out.println("下课了,"+observable.getIdentity()+" 已回到办公室");
                    observableList.remove(observable);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}