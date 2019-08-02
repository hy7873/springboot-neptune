package com.hy;

/**
 * Created by Administrator on 2018/10/13.
 */
public class Parent {

    private int a = 1;

    private int b = initb();

    Parent() {
        System.out.println("Parent 构造执行：" + a);
    }

    private int initb() {
        this.b = 12;
        System.out.println("initb 执行：" + b);
        return b;
    }

}
