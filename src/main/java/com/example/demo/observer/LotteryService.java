package com.example.demo.observer;

import com.example.demo.observer.event.EventManager;
import com.example.demo.observer.event.listener.MQEventListener;
import com.example.demo.observer.event.listener.MessageEventListener;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-10 19:31
 **/
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uid) {
        LotteryResult lotteryResult = doDraw(uid);
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uid);
}
