package com.example.demo.observer;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-10 19:56
 **/
public class LotteryServiceImpl extends LotteryService {
    @Override
    protected LotteryResult doDraw(String uid) {
        return new LotteryResult(uid);
    }
}
