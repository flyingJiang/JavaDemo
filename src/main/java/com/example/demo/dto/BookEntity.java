package com.example.demo.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * mysql 存储book
 *
 * @author cloudgyb
 * @since 2022/3/19 20:33
 */
@Data
@Entity
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
