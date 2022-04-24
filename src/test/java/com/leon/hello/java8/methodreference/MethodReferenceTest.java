package com.leon.hello.java8.methodreference;

import com.leon.hello.java8.entity.Author;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.leon.hello.java8.entity.Author.getAuthors;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: MethodReferenceTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/23 23:16
 * @Version 1.0
 * @DESCRIPTION: 方法引用
 * <p>
 * 我们在使用lambda时，如果方法体中只有一个方法的调用的话（包括构造方法）,我们可以用方法引
 * 用进一步简化代码。
 **/
public class MethodReferenceTest {

    /**
     * 引用类的静态方法
     * 类名::方法名
     */
    @Test
    public void classStaticMethodReferenceTest() {
        List<Author> authors = getAuthors();
        Stream<Author> authorStream = authors.stream();

        authorStream.map(author -> author.getAge())
                .map(age -> String.valueOf(age));

        // lambda
        // authorStream.map(Author::getAge)
        // .map(String::valueOf);
    }

    /**
     * 引用对象的实例方法
     * 对象名::方法名
     */
    @Test
    public void objectInstantiateMethodReferenceTest() {
        List<Author> authors = getAuthors();
        Stream<Author> authorStream = authors.stream();
        StringBuilder sb = new StringBuilder();
        authorStream.map(author -> author.getName())
                .forEach(name -> sb.append(name));
        // 优化后
        authorStream.map(Author::getName)
                .forEach(sb::append);
    }


    /**
     * 引用对象的实例方法
     * 对象名::方法名
     */

    interface UseString {
        String use(String str, int start, int length);
    }

    public static String subAuthorName(String str, UseString useString) {
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }

    @Test
    public void classInstantiateMethodReferenceTest() {

        subAuthorName("三更草堂", new UseString() {
            @Override
            public String use(String str, int start, int length) {
                return str.substring(start, length);
            }
        });

        // 优化后
        subAuthorName("三更草堂", String::substring);
    }

    /**
     * 构造器引用
     * 类名::new
     */
    @Test
    public void constructorMethodReferenceTest() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .map(name->new StringBuilder(name))
                .map(sb->sb.append("-三更").toString())
                .forEach(str-> System.out.println(str));
        // 优化后
        authors.stream()
                .map(Author::getName)
                .map(StringBuilder::new)
                .map(sb->sb.append("-三更").toString())
                .forEach(System.out::println);
    }

}
