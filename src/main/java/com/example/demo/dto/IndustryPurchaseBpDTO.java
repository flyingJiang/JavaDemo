package com.example.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-08 14:23
 **/
@Data
public class IndustryPurchaseBpDTO {
    private String projectNumber;
    private List<String> bpList;
}
