package com.leon.hello.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: Author
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/16 23:08
 * @Version 1.0
 * @DESCRIPTION:
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode//用于后期的去重使用
public class Author implements Comparable<Author> {

    //id
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //简介
    private String intro;
    //作品
    private List<Book> books;


    @Override
    public int compareTo(Author o) {
        return o.getAge() - this.getAge();
    }
}
