package com.example.demo.observer;

import org.junit.Test;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-10 20:00
 **/
public class LotteryServiceImplTest {
    @Test
    public void test1() {
        LotteryServiceImpl lotteryService = new LotteryServiceImpl();
        lotteryService.draw("24333");
    }
}
