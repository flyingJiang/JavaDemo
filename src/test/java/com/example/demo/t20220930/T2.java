package com.example.demo.t20220930;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @program: demoes
 * @description: 主要想测试下多种数据结构
 * 包括
 *  1、数
 *  2、链表
 *  3、队列
 *  4、栈
 *  5、堆
 *  6、数组
 *
 * @author: jiangjianfei
 * @create: 2022-09-30 20:07
 **/
public class T2 {
    @Test
    public void test1(){
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("1");
        deque.addFirst("2");
        deque.addLast("3");
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollFirst());

    }
}
