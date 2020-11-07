package com.niuh.designpattern.visitor.v2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>
 * 访问者模式案例：用户去访问博客
 * </p>
 */
public class VisitorPattern {
    public static void main(String[] args) {
        Blogs blogs = new Blogs();
        blogs.addBlog(new BlogElement("一角钱技术第一篇博文"));
        blogs.addBlog(new BlogElement("一角钱技术第二篇博文"));
        blogs.addBlog(new BlogElement("一角钱技术第三篇博文"));
        blogs.addBlog(new BlogElement("一角钱技术第四篇博文"));

        Visitor webVisit = new WebVisitor();
        Visitor appVisit = new AppVisitor();

        blogs.accept(webVisit);
        blogs.accept(appVisit);

    }
}

//抽象访问者(Visitor)
abstract class Visitor {
    public abstract void visitBlog(Element element);
}

//具体访问者(ConcreteVisitor)
class WebVisitor extends Visitor {
    public void visitBlog(Element element) {
        System.out.println("通过电脑web网站方式访问Blog:" + element.blogName);
    }
}

//具体访问者(ConcreteVisitor)
class AppVisitor extends Visitor {
    public void visitBlog(Element element) {
        System.out.println("通过手机App网站方式访问Blog:" + element.blogName);
    }
}

//抽象元素(Element)
abstract class Element {
    public String blogName;

    abstract public void accept(Visitor visotr);
}

//具体元素(ConcreteElement)
class BlogElement extends Element {
    public BlogElement(String blogname) {
        this.blogName = blogname;
    }

    public void accept(Visitor visitor) {
        visitor.visitBlog(this);
    }
}

//对象结构类(ObjectStructure)
class Blogs {
    private List<Element> blogList = new ArrayList<Element>();

    public void addBlog(Element element) {
        blogList.add(element);
    }

    public void removeBlog(Element element) {
        blogList.remove(element);
    }

    public void accept(Visitor visitor) {
        Iterator<Element> i = blogList.iterator();
        while (i.hasNext()) {
            ((Element) i.next()).accept(visitor);
        }
    }

}



