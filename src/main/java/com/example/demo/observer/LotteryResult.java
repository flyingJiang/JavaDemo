package com.example.demo.observer;

import lombok.Data;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-10 19:37
 **/
@Data
public class LotteryResult {
    private String uid;

    public LotteryResult(String uid) {
        this.uid = uid;
    }
}
