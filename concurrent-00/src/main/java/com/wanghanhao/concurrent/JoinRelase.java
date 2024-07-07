package com.wanghanhao.concurrent;

import lombok.SneakyThrows;

/**
 * @author wanghanhao
 * @version 1.0
 * @description:
 * @date 2024/7/7 16:41
 */
public class JoinRelase {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new SubThread(), "Daemon Thread!" + i);
            thread.setName("thread-" + i);
            thread.start();
            Thread.sleep(100);
        }
    }

    static class SubThread implements Runnable{
        @SneakyThrows
        @Override
        public void run() {
//            synchronized (object){
//                System.out.println("获取到锁!!!ThreadName:"+Thread.currentThread().getName());
//                Thread.currentThread().join();
//            }
            synchronized (Thread.currentThread()){
                System.out.println("获取到锁!!!ThreadName:"+Thread.currentThread().getName());
                Thread.currentThread().join();
            }
        }
    }
}
