package com.example.demo.observer.event.listener;

import cn.hutool.json.JSONUtil;
import com.example.demo.observer.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-10-10 19:38
 **/
@Slf4j
public class MessageEventListener implements EventListener {
    @Override
    public void doEvent(LotteryResult result) {
        log.info("MessageEventListener result = {}", JSONUtil.toJsonStr(result));
    }
}
