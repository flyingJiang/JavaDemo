package com.example.demo.util.annotation;

import cn.hutool.core.lang.func.Func;
import cn.hutool.json.JSONUtil;
import io.netty.handler.codec.json.JsonObjectDecoder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-13 11:26
 **/

@Slf4j
@Aspect
@Component
public class MyLogCreateAspect {

    @Pointcut("@annotation(com.example.demo.util.annotation.MyLogCreate)")
    public void myLogCreateAspect() {
    }

    @AfterReturning(pointcut = "myLogCreateAspect()", returning = "result")
    public void processMyLogCreateAspect(JoinPoint joinPoint, Object result) {
        Object[] args = joinPoint.getArgs();
        log.info("切面结束:{}", JSONUtil.toJsonStr(args));
        log.info("processMyLogCreateAspect===currentThread().getId() = {},currentThread().getName() = {}",
                currentThread().getId(), currentThread().getName());
    }

    @Before("myLogCreateAspect()")
    public void begin() {
        log.info("切面开始");
        log.info("begin===currentThread().getId() = {},currentThread().getName() = {}",
                currentThread().getId(), currentThread().getName());
    }

    // 定义事件触发节点，引用切入点
    @Around("myLogCreateAspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {

            Object[] args = pjp.getArgs();
            log.info("doAround:{}", JSONUtil.toJsonStr(args));

            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();

            //
            String sourceKey = request.getHeader("sourceKey");
            String userName = request.getHeader("userName");
            log.info("请求开始===sourceKey:{}, userName:{}", sourceKey, userName);


            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            Map<String, String> paramMap = new HashMap<>();
            Enumeration<String> paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String name = paramNames.nextElement();
                String value = request.getParameter(name);
                paramMap.put(name, value);
            }
            log.info("请求开始===地址:{}", url);
            log.info("请求开始===类型:{}", method);
            log.info("请求开始===参数:{}", JSONUtil.toJsonStr(paramMap));
            log.info("doAround===currentThread().getId() = {},currentThread().getName() = {}",
                    currentThread().getId(), currentThread().getName());
            // result的值就是被拦截方法的返回值
            Object result = pjp.proceed();
            log.info("请求结束===返回值:{}", JSONUtil.toJsonStr((result)));
            log.info("doAround===currentThread().getId() = {},currentThread().getName() = {}",
                    currentThread().getId(), currentThread().getName());
            return result;
        } catch (Exception e) {
            log.error("Exception");

        } finally {
            log.info("finally");

        }
        return null;
    }
}
