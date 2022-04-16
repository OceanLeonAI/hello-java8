package com.leon.hello.java8.lambda;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

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

    @Test
    public void newThreadTest() {
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

    @Test
    public void newThreadWithLambdaTest() {
        new Thread(() -> System.out.println("这是一个lambda实现的线程: "
                + Thread.currentThread().getId()
                + "---"
                + Thread.currentThread().getName()
        )).start();
    }

    @Test
    public void calculateNumTest() {

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
     * 两数之和操作
     *
     * @param intBinaryOperator
     * @return
     */
    private int calculateNum(IntBinaryOperator intBinaryOperator) {
        int a = 1;
        int b = 1;
        return intBinaryOperator.applyAsInt(a, b);
    }

    @Test
    public void calculateNumWithLambdaTest() {

        int i = calculateNum((left, right) -> left + right);

        System.out.println("i = " + i);

    }


}
