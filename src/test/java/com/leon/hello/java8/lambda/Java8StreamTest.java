package com.leon.hello.java8.lambda;

import com.leon.hello.java8.entity.Author;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.System.out;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: Java8StreamTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/20 22:08
 * @Version 1.0
 * @DESCRIPTION: Stream 常用操作
 * <p>
 * 注意事项
 * 惰性求值（如果没有终结操作，没有中间操作是不会得到执行的）
 * 流是一次性的（一旦一个流对象经过一个终结操作后。这个流就不能再被使用）
 * 不会影响原数据（我们在流中可以多数据做很多处理。但是正常情况下是不会影响原来集合中的元素的。这往往也是我们期望的）
 **/
public class Java8StreamTest {

    /**
     * 打印所有年龄小于18的作家的名字，并且要注意去重
     */
    @Test
    public void quickStart() {

        // 获取数据
        List<Author> authors = Author.getAuthors();

        authors.stream() // 转换为流对象
                .distinct() // 去重
                .filter(author -> author.getAge() > 18) // 过滤年龄小于18的
                .forEach(author -> out.println(author.getName())); // 打印结果
    }

    // ==================== 创建流 begin ====================

    /**
     * 单列集合
     * Object.stream()
     */
    @Test
    public void createStreamBySingleColumn() {
        List<Author> authors = Author.getAuthors();
        Stream<Author> stream = authors.stream();
    }

    // 数组
    @Test
    public void createStreamByArray() {

        int[] intArray = {1, 2, 3, 4, 5, 6};

        IntStream intStream = Arrays.stream(intArray);

        Stream<int[]> intArray1 = Stream.of(intArray);

    }

    /**
     * 双列集合
     */
    @Test
    public void createStreamByDoubleColumn() {

        Map map = new HashMap<String, Object>();
        map.put("name", "leon");
        map.put("age", 18);

        Stream entrySetStream = map.entrySet().stream();

        Stream keySetStream = map.keySet().stream();

        Stream valuesStream = map.values().stream();


    }

    // ==================== 创建流 end ====================

    // ==================== 中间操作 begin ====================

    /**
     * filter 可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中。
     * <p>
     * 打印所有姓名长度大于1的作家的姓名
     */
    @Test
    public void filter() {
    }

    /**
     * map 可以把对流中的元素进行计算或转换。
     * <p>
     * 打印所有作家的姓名
     */
    @Test
    public void map() {
    }

    /**
     * distinct 可以去除流中的重复元素。
     * 注意：distinct方法是依赖Object的equals方法来判断是否是相同对象的。所以需要注意重写equals
     * 方法。
     * <p>
     * 打印所有作家的姓名，并且要求其中不能有重复元素。
     */
    @Test
    public void distinct() {
    }

    /**
     * sorted 可以对流中的元素进行排序。
     * 注意：如果调用空参的sorted()方法，需要流中的元素是实现了Comparable。
     * <p>
     * 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素。
     */
    @Test
    public void sorted() {
    }

    /**
     * limit 可以设置流的最大长度，超出的部分将被抛弃。
     * <p>
     * 对流中的元素按照年龄进行降序排序，并且要求不能有重复的元素,然后打印其中年龄最大的两个作家
     * 的姓名。
     */
    @Test
    public void limit() {
    }

    /**
     * skip 跳过流中的前n个元素，返回剩下的元素。
     * <p>
     * 打印除了年龄最大的作家外的其他作家，要求不能有重复元素，并且按照年龄降序排序。
     */
    @Test
    public void skip() {
    }

    /**
     * flatMap map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对
     * 象作为流中的元素。
     * <p>
     * 打印所有书籍的名字。要求对重复的元素进行去重。
     */
    @Test
    public void flatMap1() {
    }

    /**
     * flatMap map只能把一个对象转换成另一个对象来作为流中的元素。而flatMap可以把一个对象转换成多个对
     *
     * @see <a href="https://blog.csdn.net/catoop/article/details/105987386">Java Stream的flatMap和map的区别</a>
     * 象作为流中的元素。
     * <p>
     * 打印现有数据的所有分类。要求对分类进行去重。不能出现这种格式：哲学,爱情
     */
    @Test
    public void flatMap2() {
    }


    // ==================== 中间操作 end ====================

    // ==================== 终结操作 begin ====================

    // ==================== 终结操作 end ====================

}
