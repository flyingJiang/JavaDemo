package com.example.demo.dto;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.Data;

import java.util.List;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-02 20:03
 **/
@Data
public class HttpResDTO {
    private Boolean success;
    private String status;
    private List<ProjectUrlDTO> result;
}
