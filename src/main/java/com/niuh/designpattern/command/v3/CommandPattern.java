package com.niuh.designpattern.command.v3;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 命令模式案例
 * </p>
 */
public class CommandPattern {

    public static void main(String[] args) {
        //命令接收者
        CourseVideo courseVideo = new CourseVideo("设计模式系列");

        //创建命令
        OpenCourseVideoCommand openCourseVideoCommand = new OpenCourseVideoCommand(courseVideo);
        CloseCourseVideoCommand closeCourseVideoCommand = new CloseCourseVideoCommand(courseVideo);

        //创建执行人
        User user = new User();

        //添加命令
        user.addCommand(openCourseVideoCommand);
        user.addCommand(closeCourseVideoCommand);

        //执行
        user.executeCommands();
    }
}

// 步骤1：声明执行命令的接口，拥有执行命令的抽象方法 execute()。
interface Command {
    void execute();
}

// 步骤2：定义具体命令角色，创建打开课程链接 和 关闭课程连接

/**
 * 打开课程链接
 */
class OpenCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public OpenCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.open();
    }
}

/**
 * 关闭课程链接
 */
class CloseCourseVideoCommand implements Command {

    private CourseVideo courseVideo;

    public CloseCourseVideoCommand(CourseVideo courseVideo) {
        this.courseVideo = courseVideo;
    }

    @Override
    public void execute() {
        courseVideo.close();
    }
}


// 步骤3：定义接收者角色，执行命令功能的相关操作，是具体命令对象业务的真正实现者
class CourseVideo {

    private String name;

    public CourseVideo(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println(this.name + "课程视频开放。");
    }

    public void close() {
        System.out.println(this.name + "课程视频关闭。");
    }
}

// 步骤4：创建User对象为请求的发送者，即请求者角色
class User {

    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands() {
        commands.forEach(Command::execute);
        commands.clear();
    }
}
