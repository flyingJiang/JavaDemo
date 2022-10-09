package com.example.demo.t20220926;


/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-09 16:02
 **/
public class T2 {
    public int m1(int x) {
        return x + sum(x + 1, x + 2);
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
