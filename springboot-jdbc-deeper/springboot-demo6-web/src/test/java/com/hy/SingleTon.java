package com.hy;

/**
 * Created by Administrator on 2018/10/15.
 */
public class SingleTon {

    private static SingleTon singleTon;

    private SingleTon() {

    }

    public static SingleTon getSingleTon() {
        if (singleTon != null) {
            return singleTon;
        } else {
            synchronized (SingleTon.class){
                if (singleTon == null)
                    singleTon = new SingleTon();
            }
        }
        return singleTon;
    }
}
