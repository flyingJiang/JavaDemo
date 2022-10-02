package com.example.demo.controller;

import cn.hutool.json.JSONUtil;
import com.example.demo.dto.User;
import com.example.demo.service.MyAspectService;
import com.example.demo.util.annotation.MyLogCreate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.lang.Thread.currentThread;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-13 11:18
 **/
@Slf4j
@RestController
@RequestMapping("/myAspectController")
public class MyAspectController {
    @Autowired
    private MyAspectService myAspectService;
    @MyLogCreate
    @PostMapping("/test")
    public Object test(HttpServletRequest request, @RequestBody User user) {
        String sourceKey = request.getHeader("sourceKey");
        log.info("http://localhost:8080/myAspectController/test, sourceKey = {}, user = {}",
                sourceKey, JSONUtil.toJsonStr(user));
        log.info("test===currentThread().getId() = {},currentThread().getName() = {}",
                currentThread().getId(),currentThread().getName());
        return "http://localhost:8080/myAspectController/test"+myAspectService.get();
    }
}
