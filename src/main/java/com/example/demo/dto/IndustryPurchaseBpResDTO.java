package com.example.demo.dto;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @program: demoes
 * @description:
 * @author: jiangjianfei
 * @create: 2022-08-08 14:24
 **/
@Data
public class IndustryPurchaseBpResDTO {
    private Boolean success;
    private Integer status;
    private List<IndustryPurchaseBpDTO> result;
}
