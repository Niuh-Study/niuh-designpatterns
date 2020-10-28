package com.niuh.designpattern.templatemethod.v2;

/**
 * 模版方法模式案例
 * <p>
 * 用模板方法模式实现出国留学手续设计程序
 */
public class TemplateMethodPattern {

    public static void main(String[] args) {
        StudyAbroad tm=new StudyInAmerica();
        tm.templateMethod();
    }
}

// 步骤1：定义一个出国留学的抽象类 StudyAbroad
abstract class StudyAbroad {
    //模板方法
    public void templateMethod() {
        lookingForSchool(); //索取学校资料
        applyForEnrol();    //入学申请
        applyForPassport(); //办理因私出国护照、出境卡和公证
        applyForVisa();     //申请签证
        readyGoAbroad();    //体检、订机票、准备行装
        arriving();         //抵达
    }

    public void applyForPassport() {
        System.out.println("三.办理因私出国护照、出境卡和公证：");
        System.out.println("  1）持录取通知书、本人户口簿或身份证向户口所在地公安机关申请办理因私出国护照和出境卡。");
        System.out.println("  2）办理出生公证书，学历、学位和成绩公证，经历证书，亲属关系公证，经济担保公证。");
    }

    public void applyForVisa() {
        System.out.println("四.申请签证：");
        System.out.println("  1）准备申请国外境签证所需的各种资料，包括个人学历、成绩单、工作经历的证明；个人及家庭收入、资金和财产证明；家庭成员的关系证明等；");
        System.out.println("  2）向拟留学国家驻华使(领)馆申请入境签证。申请时需按要求填写有关表格，递交必需的证明材料，缴纳签证。有的国家(比如美国、英国、加拿大等)在申请签证时会要求申请人前往使(领)馆进行面试。");
    }

    public void readyGoAbroad() {
        System.out.println("五.体检、订机票、准备行装：");
        System.out.println("  1）进行身体检查、免疫检查和接种传染病疫苗；");
        System.out.println("  2）确定机票时间、航班和转机地点。");
    }

    //索取学校资料
    public abstract void lookingForSchool();

    //入学申请
    public abstract void applyForEnrol();

    //抵达
    public abstract void arriving();
}

// 步骤2：定义具体子类: 美国留学
class StudyInAmerica extends StudyAbroad {

    @Override
    public void lookingForSchool() {
        System.out.println("一.索取学校以下资料：");
        System.out.println("  1）对留学意向国家的政治、经济、文化背景和教育体制、学术水平进行较为全面的了解；");
        System.out.println("  2）全面了解和掌握国外学校的情况，包括历史、学费、学制、专业、师资配备、教学设施、学术地位、学生人数等；");
        System.out.println("  3）了解该学校的住宿、交通、医疗保险情况如何；");
        System.out.println("  4）该学校在中国是否有授权代理招生的留学中介公司？");
        System.out.println("  5）掌握留学签证情况；");
        System.out.println("  6）该国政府是否允许留学生合法打工？");
        System.out.println("  8）毕业之后可否移民？");
        System.out.println("  9）文凭是否受到我国认可？");
    }

    @Override
    public void applyForEnrol() {
        System.out.println("二.入学申请：");
        System.out.println("  1）填写报名表；");
        System.out.println("  2）将报名表、个人学历证明、最近的学习成绩单、推荐信、个人简历、托福或雅思语言考试成绩单等资料寄往所申请的学校；");
        System.out.println("  3）为了给签证办理留有充裕的时间，建议越早申请越好，一般提前1年就比较从容。");
    }

    @Override
    public void arriving() {
        System.out.println("六.抵达目标学校：");
        System.out.println("  1）安排住宿；");
        System.out.println("  2）了解校园及周边环境。");
    }
}