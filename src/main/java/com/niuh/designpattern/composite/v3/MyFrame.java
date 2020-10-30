package com.niuh.designpattern.composite.v3;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * java.awt中的组合模式
 */
public class MyFrame extends Frame {

    public MyFrame(String title) {
        super(title);
    }

    public static void main(String[] args) {

        MyFrame frame = new MyFrame("组合模式之 Frame");

        // 定义三个构件，添加到Frame中去
        Button button = new Button("按钮 A");
        Label label = new Label("这是一个 AWT Label!");
        TextField textField = new TextField("这是一个 AWT TextField!");

        frame.add(button, BorderLayout.EAST);
        frame.add(label, BorderLayout.SOUTH);
        frame.add(textField, BorderLayout.NORTH);

        // 定义一个 Panel，在Panel中添加三个构件，然后再把Panel添加到Frame中去
        Panel panel = new Panel();
        panel.setBackground(Color.pink);

        Label lable1 = new Label("用户名");
        TextField textField1 = new TextField("请输入用户名：", 20);
        Button button1 = new Button("确定");
        panel.add(lable1);
        panel.add(textField1);
        panel.add(button1);

        frame.add(panel, BorderLayout.CENTER);

        // 设置Frame的属性
        frame.setSize(500, 300);
        frame.setBackground(Color.orange);
        // 设置点击关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }
}
