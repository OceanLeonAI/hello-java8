package com.leon.hello.java8.optional;

import com.leon.hello.java8.entity.Author;
import com.leon.hello.java8.entity.Book;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: Java8OptionalTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/22 18:23
 * @Version 1.0
 * @DESCRIPTION: Optional测试
 **/
public class Java8OptionalTest {

    // ==================== 创建对象 begin ====================

    /**
     * public static <T> Optional<T> ofNullable(T value) {
     * return value == null ? empty() : of(value);
     * }
     * <p>
     * 注意入参一定不为 null
     */
    @Test
    public void ofNullable() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        Optional<Author> optionalOf = Optional.of(author);
        Optional<Object> optionalEmpty = Optional.empty();
    }

    // ==================== 创建对象 end ====================

    // ==================== 安全消费值 begin ====================

    @Test
    public void ifPresent() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        ofNullableAuthor.ifPresent(author1 -> System.out.println(author1.getName()));
    }

    // ==================== 安全消费值 end ====================

    // ==================== 获取值 begin ====================

    /**
     * 不推荐使用，容易空指针
     */
    @Test
    public void optionalGet() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        Author author1 = ofNullableAuthor.get();
    }

    // ==================== 获取值 end ====================

    // ==================== 安全获取值 begin ====================

    /**
     * 获取数据并且设置数据为空时的默认值。如果数据不为空就能获取到该数据。如果为空则根据你传
     * 入的参数来创建对象作为默认值返回。
     */
    @Test
    public void orElseGet() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        Author author1 = ofNullableAuthor.orElseGet(() -> new Author());
    }

    /**
     * 获取数据，如果数据不为空就能获取到该数据。如果为空则根据你传入的参数来创建异常抛出。
     */
    @Test
    public void orElseThrow() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        try {
            Author author1 = ofNullableAuthor.orElseThrow((Supplier<Throwable>)
                    () -> new RuntimeException("author为空"));
            System.out.println(author.getName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    // ==================== 安全获取值 end ====================

    // ==================== 过滤 begin ====================

    /**
     * 我们可以使用isPresent方法进行是否存在数据的判断。如果为空返回值为false,如果不为空，返回值
     * 为true。但是这种方式并不能体现Optional的好处，更推荐使用ifPresent方法。
     */
    @Test
    public void filter() {
        Author authorNew = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(authorNew);
        ofNullableAuthor
                .filter(author -> author.getAge() > 100)
                .ifPresent(author -> System.out.println(author.getName()));
    }

    // ==================== 过滤 end ====================

    // ==================== 判断 begin ====================

    /**
     * 我们可以使用isPresent方法进行是否存在数据的判断。如果为空返回值为false,如果不为空，返回值
     * 为true。但是这种方式并不能体现Optional的好处，更推荐使用ifPresent方法。
     */
    @Test
    public void isPresent() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        if (ofNullableAuthor.isPresent()) {
            System.out.println(ofNullableAuthor.get().getName());
        }
    }

    // ==================== 判断 end ====================

    // ==================== 数据转换 begin ====================

    /**
     * Optional还提供了map可以让我们的对数据进行转换，并且转换得到的数据也还是被Optional包装好
     * 的，保证了我们的使用安全。
     */
    @Test
    public void optionalToMap() {
        Author author = new Author();
        Optional<Author> ofNullableAuthor = Optional.ofNullable(author);
        Optional<List<Book>> bookList = ofNullableAuthor.map(author1 -> author1.getBooks());
        bookList.ifPresent(books -> {
            System.out.println(books);
        });
    }

    // ==================== 数据转换 end ====================


}
