package com.leon.hello.java8.lambda;

import org.junit.Test;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/**
 * @PROJECT_NAME: hello-java8
 * @CLASS_NAME: Java8LambdaTest
 * @AUTHOR: OceanLeonAI
 * @CREATED_DATE: 2022/4/16 23:12
 * @Version 1.0
 * @DESCRIPTION: lambda 不关心参数类型和名称，只在乎操作
 **/
public class Java8LambdaTest {

    @Test
    public void helloJava8LambdaTest() {
        System.out.println("hello helloJava8LambdaTest");
    }

    // ======================= 案例一 begin =======================

    /**
     * 创建线程并启动时可以使用匿名内部类的写法
     */
    @Test
    public void newThreadWithAnonymousFunction() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个匿名函数实现的线程: "
                        + Thread.currentThread().getId()
                        + "---"
                        + Thread.currentThread().getName()
                );
            }
        }).start();

    }

    /**
     * 创建线程并启动时lambda写法
     */
    @Test
    public void newThreadWithLambda() {
        new Thread(() -> System.out.println("这是一个lambda实现的线程: "
                + Thread.currentThread().getId()
                + "---"
                + Thread.currentThread().getName()
        )).start();
    }

    // ======================= 案例一 end =======================


    // ======================= 案例二 end =======================

    /**
     * 两数之和操作
     *
     * @param intBinaryOperator 是接口
     * @return
     */
    public int calculateNum(IntBinaryOperator intBinaryOperator) {
        int a = 1;
        int b = 1;
        return intBinaryOperator.applyAsInt(a, b);
    }

    /**
     * 匿名内部类
     */
    @Test
    public void calculateNumWithAnonymousFunction() {
        int i = calculateNum(new IntBinaryOperator() {
            /**
             * 返回两数之和
             * @param left
             * @param right
             * @return
             */
            @Override
            public int applyAsInt(int left, int right) {
                return left + right;
            }
        });
        System.out.println("i = " + i);
    }

    /**
     * lambda 实现
     */
    @Test
    public void calculateNumWithLambda() {
        int i = calculateNum((left, right) -> left + right);
        System.out.println("i = " + i);
    }

    // ======================= 案例二 begin =======================


    // ======================= 案例三 begin =======================

    /**
     * 定义打印数字函数
     *
     * @param predicate 接口
     */
    public void printNum(IntPredicate predicate) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            if (predicate.test(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 打印偶数
     */
    @Test
    public void printNumWithAnonymousFunction() {
        printNum(new IntPredicate() {
            @Override
            public boolean test(int value) {
                return value % 2 == 0;
            }
        });
    }

    /**
     * 打印偶数
     */
    @Test
    public void printNumWithLambda() {
        printNum((int value) -> {
            return value % 2 == 0;
        });

        // printNum(value -> value % 2 == 0);

    }

    // ======================= 案例三 end =======================


    // ======================= 案例四 begin =======================

    /**
     * 类型转换
     *
     * @param function
     * @param <R>
     * @return
     */
    public <R> R typeConver(Function<String, R> function) {
        String str = "1234567890";
        R result = function.apply(str);
        return result;
    }

    /**
     * 类型转换--匿名函数
     */
    @Test
    public void typeConverWithAnonymousFunction() {

        Integer integer = typeConver(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        });

        System.out.println("integer = " + integer);
    }

    /**
     * 类型转换--lambda
     */
    @Test
    public void typeConverWithLambda() {

        Integer integer = typeConver(s -> Integer.valueOf(s));

        System.out.println("integer = " + integer);
    }

    // ======================= 案例四 end =======================


    // ======================= 案例无 begin =======================

    /**
     * @param consumer 接口
     */
    public void foreachArr(IntConsumer consumer) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : arr) {
            consumer.accept(i);
        }
    }

    /**
     * 类型转换--匿名函数
     */
    @Test
    public void foreachArrWithAnonymousFunction() {

        foreachArr(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println("value = " + value);
            }
        });


    }

    /**
     * 类型转换--lambda
     */
    @Test
    public void foreachArrWithLambda() {

        // foreachArr(value -> System.out.println("value = " + value));

        foreachArr((int value) -> {
            System.out.println("value = " + value);
        });
    }

    // ======================= 案例无 end =======================


}
