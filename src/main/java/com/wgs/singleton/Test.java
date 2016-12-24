package com.wgs.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2016/12/24 0024.
 */
public class Test {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();
        int threadNum = 100;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for(int i=0;i<threadNum;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<1000000;i++){
                        //饿汉式单例模式 总耗时：29
//						Object o = SingletonDemo1.getInstance();
                        //懒汉式单例模式 总耗时：1395
//                        Object o = SingletonDemo2.getInstance();
                        //双重检查锁实现单例模式 总耗时：32
//                        Object o = SingletonDemo3.getInstance();
                        //静态内部类实现单例模式 总耗时：56
//                        Object o = SingletonDemo4.getInstance();
                        //枚举式实现单例模式 总耗时：48
                        Object o = SingletonDemo5.INSTANCE;
                    }

                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();	//main线程阻塞，直到计数器变为0，才会继续往下执行！

        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }

}
