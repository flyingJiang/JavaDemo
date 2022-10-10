package com.example.demo.observer.event.listener;

import com.example.demo.observer.LotteryResult;

public interface EventListener {
    void doEvent(LotteryResult result);
}
