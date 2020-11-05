package com.niuh.designpattern.mediator.v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 中介者模式案例，用中介者模式编写一个“北京房地产交流平台”程序
 * </p>
 */
public class MediatorPattern {
    public static void main(String[] args) {
        //房产中介
        Medium md = new EstateMedium();
        Customer member1, member2;
        member1 = new Seller("张三(卖方)");
        member2 = new Buyer("李四(买方)");
        //客户注册
        md.register(member1);
        md.register(member2);
    }
}

//抽象中介者：中介公司
interface Medium {
    //客户注册
    void register(Customer member);

    //转发
    void relay(String from, String ad);
}

//具体中介者：房地产中介
class EstateMedium implements Medium {
    private List<Customer> members = new ArrayList<Customer>();

    public void register(Customer member) {
        if (!members.contains(member)) {
            members.add(member);
            member.setMedium(this);
        }
    }

    public void relay(String from, String ad) {
        for (Customer ob : members) {
            String name = ob.getName();
            if (!name.equals(from)) {
                ((Customer) ob).receive(from, ad);
            }
        }
    }
}

//抽象同事类：客户
abstract class Customer extends JFrame implements ActionListener {
    private static final long serialVersionUID = -7219939540794786080L;
    protected Medium medium;
    protected String name;
    JTextField SentText;
    JTextArea ReceiveArea;

    public Customer(String name) {
        super(name);
        this.name = name;
    }

    void ClientWindow(int x, int y) {
        Container cp;
        JScrollPane sp;
        JPanel p1, p2;
        cp = this.getContentPane();
        SentText = new JTextField(18);
        ReceiveArea = new JTextArea(10, 18);
        ReceiveArea.setEditable(false);
        p1 = new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("接收内容："));
        p1.add(ReceiveArea);
        sp = new JScrollPane(p1);
        cp.add(sp, BorderLayout.NORTH);
        p2 = new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("发送内容："));
        p2.add(SentText);
        cp.add(p2, BorderLayout.SOUTH);
        SentText.addActionListener(this);
        this.setLocation(x, y);
        this.setSize(250, 330);
        this.setResizable(false); //窗口大小不可调整
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String tempInfo = SentText.getText().trim();
        SentText.setText("");
        this.send(tempInfo);
    }

    public String getName() {
        return name;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public abstract void send(String ad);

    public abstract void receive(String from, String ad);
}

//具体同事类：卖方
class Seller extends Customer {
    private static final long serialVersionUID = -1443076716629516027L;

    public Seller(String name) {
        super(name);
        ClientWindow(50, 100);
    }

    public void send(String ad) {
        ReceiveArea.append("我(卖方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, ad);
    }

    public void receive(String from, String ad) {
        ReceiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}

//具体同事类：买方
class Buyer extends Customer {
    private static final long serialVersionUID = -474879276076308825L;

    public Buyer(String name) {
        super(name);
        ClientWindow(350, 100);
    }

    public void send(String ad) {
        ReceiveArea.append("我(买方)说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, ad);
    }

    public void receive(String from, String ad) {
        ReceiveArea.append(from + "说: " + ad + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}
