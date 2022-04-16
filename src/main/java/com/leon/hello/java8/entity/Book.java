package com.leon.hello.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: Book
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/16 23:08
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode//用于后期的去重使用
public class Book {
    //id
    private Long id;
    //书名
    private String name;

    //分类
    private String category;//"哲学,小说"

    //评分
    private Integer score;

    //简介
    private String intro;
}
