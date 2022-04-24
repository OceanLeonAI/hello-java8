package com.leon.hello.java8.advanced;

import com.leon.hello.java8.entity.Author;
import org.junit.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.leon.hello.java8.entity.Author.getAuthors;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: AdvancedTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/24 16:34
 * @Version 1.0
 * @DESCRIPTION: 高级用法
 **/
public class AdvancedTest {

    /**
     * 基本数据类型优化
     * <p>
     * 我们之前用到的很多Stream的方法由于都使用了泛型。所以涉及到的参数和返回值都是引用数据类
     * 型。
     * 即使我们操作的是整数小数，但是实际用的都是他们的包装类。JDK5中引入的自动装箱和自动拆箱让
     * 我们在使用对应的包装类时就好像使用基本数据类型一样方便。但是你一定要知道装箱和拆箱肯定是要
     * 消耗时间的。虽然这个时间消耗很下。但是在大量的数据不断的重复装箱拆箱的时候，你就不能无视这
     * 个时间损耗了。
     * 所以为了让我们能够对这部分的时间消耗进行优化。Stream还提供了很多专门针对基本数据类型的
     * 方法。
     * 例如：mapToInt,mapToLong,mapToDouble,flatMapToInt,flatMapToDouble等。
     */
    @Test
    public void mapToIntTest() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age -> age > 18)
                .map(age -> age + 2)
                .forEach(System.out::println);
        authors.stream()
                .mapToInt(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age -> age > 18)
                .map(age -> age + 2)
                .forEach(System.out::println);
    }

    /**
     * 并行流
     * <p>
     * 当流中有大量元素时，我们可以使用并行流去提高操作的效率。其实并行流就是把任务分配给多个线
     * 程去完全。如果我们自己去用代码实现的话其实会非常的复杂，并且要求你对并发编程有足够的理解和
     * 认识。而如果我们使用Stream的话，我们只需要修改一个方法的调用就可以使用并行流来帮我们实
     * 现，从而提高效率。
     * parallel方法可以把串行流转换成并行流。
     */
    @Test
    public void parallelStreamTest() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = stream.parallel()
                .peek(new Consumer<Integer>() { // peek 用于调试
                    @Override
                    public void accept(Integer num) {
                        System.out.println(num + "---" + Thread.currentThread().getName());
                    }
                })
                .filter(num -> num > 5)
                .reduce((result, ele) -> result + ele)
                .get();
        System.out.println(sum);

        // 也可以通过parallelStream直接获取并行流对象。
        List<Author> authors = getAuthors();
        authors.parallelStream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .filter(age -> age > 18)
                .map(age -> age + 2)
                .forEach(System.out::println);
    }

}
