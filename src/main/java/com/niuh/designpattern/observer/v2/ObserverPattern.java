package com.niuh.designpattern.observer.v2;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式
 */
public class ObserverPattern {

    // 步骤6：开始上课，开始记录报告
    public static void main(String[] args) {
        // 创建学生主体
        StudentSubject studentSubject = new StudentSubject();

        // 创建观察者老师
        TeacherObserver teacherObversable = new TeacherObserver();

        // 创建观察者班主任
        HeadTeacherObserver headTeacherObserver = new HeadTeacherObserver();

        // 学生反映上课状态
        studentSubject.setState("讲的不错,很好!");
        studentSubject.addObserver(teacherObversable);
        studentSubject.addObserver(headTeacherObserver);

        // 开始上课
        studentSubject.doNotify();

        // 上课结束
        studentSubject.deleteObserver(headTeacherObserver);
        studentSubject.deleteObserver(teacherObversable);
    }
}


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





/**
 * 老师类
 * - 观察者之一
 * - 观察学生的上课情况
 */
class TeacherObserver implements Observer {

    private Course course;

    @Override
    public void update(Observable o, Object arg)  {
        DateFormat df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.CHINA);
        System.out.println("我是王老师,正在讲课中...");

        course = new Course(new Date(), "A栋教学楼", "高等数学");
        System.out.println("今天上课时间:" + df.format(course.getTime()) + " 地点:" + course.getPlace() + " 上课内容:" + course.getContent());
    }
}

/**
 * 班主任来听课
 * - 观察者之一
 * - 观察学生的上课情况
 */
class HeadTeacherObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我是班主任来听课了,正在检查课程质量...");
        System.out.println("学生反馈课程质量为:" + arg);
    }
}


/**
 * 学生主体
 * - 被观察的对象
 */
class StudentSubject extends Observable {
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

    public void doNotify() {
        // 设置标志
        this.setChanged();
        // 通知观察者做出相应动作
        this.notifyObservers(state);
    }
}