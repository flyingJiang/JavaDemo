package com.example.demo.dto;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-09-13 12:13
 **/
@Data
public class User {
    private String username;
    private String password;
    private LocalDate localDate;
    private Date date;
}
