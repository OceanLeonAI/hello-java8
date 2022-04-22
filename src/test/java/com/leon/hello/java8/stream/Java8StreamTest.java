package com.leon.hello.java8.stream;

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

    /**
     * forEach 对流中的元素进行遍历操作，我们通过传入的参数去指定对遍历到的元素进行什么具体操作。
     *
     * <p>
     * 输出所有作家的名字
     */
    @Test
    public void forEach() {
    }

    /**
     * count 可以用来获取当前流中元素的个数。
     *
     * <p>
     * 打印这些作家的所出书籍的数目，注意删除重复元素。
     */
    @Test
    public void count() {
    }

    /**
     * max&min 可以用来或者流中的最值。
     *
     * <p>
     * 分别获取这些作家的所出书籍的最高分和最低分并打印。
     */
    @Test
    public void maxOrMin() {
    }

    /**
     * collect 把当前流转换成一个集合。
     *
     * <p>
     * 1.获取一个存放所有作者名字的List集合。
     * 2.获取一个所有书名的Set集合。
     * 3.获取一个Map集合，map的key为作者名，value为List
     */
    @Test
    public void collect() {
    }

    // ==================== 终结操作 end ====================


    // ==================== 查找与匹配 begin ====================

    /**
     * anyMatch 可以用来判断是否有任意符合匹配条件的元素，结果为boolean类型。
     *
     * <p>
     * 判断是否有年龄在29以上的作家
     */
    @Test
    public void anyMatch() {
    }

    /**
     * allMatch 可以用来判断是否都符合匹配条件，结果为boolean类型。如果都符合结果为true，否则结果为false。
     *
     * <p>
     * 判断是否有年龄在29以上的作家
     */
    @Test
    public void allMatch() {
    }

    /**
     * noneMatch 可以判断流中的元素是否都不符合匹配条件。如果都不符合结果为true，否则结果为false
     *
     * <p>
     * 判断作家是否都没有超过100岁的。
     */
    @Test
    public void noneMatch() {
    }

    /**
     * findAny 获取流中的任意一个元素。该方法没有办法保证获取的一定是流中的第一个元素。
     *
     * <p>
     * 获取任意一个年龄大于18的作家，如果存在就输出他的名字
     */
    @Test
    public void findAny() {
    }

    /**
     * findFirst 获取流中的第一个元素。
     *
     * <p>
     * 获取一个年龄最小的作家，并输出他的姓名。
     */
    @Test
    public void findFirst() {
    }

    // ==================== reduce归并(缩减操作) begin ====================

    /**
     *对流中的数据按照你指定的计算方式计算出一个结果。（缩减操作）
     * reduce的作用是把stream中的元素给组合起来，我们可以传入一个初始值，它会按照我们的计算方
     * 式依次拿流中的元素和初始化值进行计算，计算结果再和后面的元素计算。
     * reduce两个参数的重载形式内部的计算方式如下
     * T result = identity;
     * for (T element : this stream)
     *      result = accumulator.apply(result, element)
     * return result;
     *
     * 其中identity就是我们可以通过方法参数传入的初始值，accumulator的apply具体进行什么计算也是
     * 我们通过方法参数来确定的。
     */

    /**
     * 使用reduce求所有作者年龄的和
     */
    @Test
    public void reduce1() {
    }

    /**
     * 使用reduce求所有作者中年龄的最大值
     */
    @Test
    public void reduce2() {
    }

    /**
     * 使用reduce求所有作者中年龄的最小值
     */
    @Test
    public void reduce3() {

    }

    /**
     * reduce一个参数的重载形式内部的计算
     *         boolean foundAny = false;
     *         T result = null;
     *         for (T element : this stream) {
     *             if (!foundAny) {
     *                 foundAny = true;
     *                 result = element;
     *             } e
     *                     lse
     *             result = accumulator.apply(result, element);
     *         } r
     *         eturn foundAny ? Optional.of(result) : Optional.empty();
     *
     */

    /**
     * 如果用一个参数的重载方法去求最小值
     */
    @Test
    public void reduce4() {

    }

    // ==================== reduce归并(缩减操作) end ====================

}
