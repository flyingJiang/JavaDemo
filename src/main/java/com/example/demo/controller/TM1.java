package com.example.demo.controller;

import java.math.BigDecimal;

/**
 * @program: JavaDemo
 * @description:
 * @author: jiangjianfei
 * @create: 2023-08-30 15:59
 **/
public class TM1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random()*5.0/1000+0.01);
        }

        BigDecimal priceMax = BigDecimal.TEN;

        // 脱敏逻辑：额外上升（1%-1.5%随机数），向上取整，无小数
        double rate = getRate();
        priceMax = priceMax.multiply(BigDecimal.valueOf(rate));
        priceMax = priceMax.setScale(0, BigDecimal.ROUND_UP);
    }

    private static double getRate() {
        double rate = Math.random() * 5.0 / 1000 + 0.01;
        return rate + 1.0;
    }
}
