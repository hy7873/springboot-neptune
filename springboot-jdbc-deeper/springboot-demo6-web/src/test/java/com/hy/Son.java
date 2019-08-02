package com.hy;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/10/13.
 */
public class Son extends Parent{

    private int c = 1;

    private int d = initd();

   public Son() {
        System.out.println("Son 构造执行：" + c);
    }


    private int initd() {
        this.d = 13;
        System.out.println("initd 执行：" + d);
        return d;
    }


    public static void main(String[] args) {
       /* Son son = new Son();


        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();

        ReentrantLock reentrantLock = new ReentrantLock();*/

        List<Integer> list = Arrays.asList(2,2,3,3,5,6,6,7,8,100,100);
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            for (int j = i + 1; j < list.size();j++) {
                if (list.get(i) == list.get(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list2.add(list.get(i));
            }
        }
        System.out.println(new Gson().toJson(list2));


    }



    @Test
    public void test1() {
        int i = 0;
        i++;
        test1();
    }

}
