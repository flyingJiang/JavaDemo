package com.example.demo.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Document定义在Elasticsearch中索引信息
 * @Id定义了Elasticsearch的_id
 * @Field定义字段类型等信息
 *
 * @author geng
 * 2020/12/18
 */
@Data
@Document(indexName = "book", createIndex = true)
public class Book {
    @Id
    @Field(type = FieldType.Text)
    private String id;
    @Field(analyzer = "ik_max_word")
    private String title;
    @Field(analyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date updateTime;
}
