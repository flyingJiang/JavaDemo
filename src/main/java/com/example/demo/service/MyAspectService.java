package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-13 13:59
 **/
@Slf4j
@Service
public class MyAspectService {
    public String get() {
        log.info("MyAspectService");
        return System.currentTimeMillis() + "";
    }
}
