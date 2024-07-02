package com.wanghanhao.concurrent;

import lombok.SneakyThrows;

/**
 * @author wanghanhao
 * @version 1.0
 * @description: 阅读StackLog,排查死锁
 * @date 2024/7/2 23:26
 */
public class ReadStackLog {
    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"TimeWaitingThread").start();
        new Thread(new Waiting(),"WaitingThread").start();
        new Thread(new Blocked(),"BlockedThread-1").start();
        new Thread(new Blocked(),"BlockedThread-2").start();

    }
}
//该线程不断地进行睡眠
class TimeWaiting implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        while(true){
            Thread.sleep(1000000);
        }
    }
}

//该线程在Waiting.class实例上等待
class Waiting implements Runnable{
    @Override
    public void run() {
        while (true){
            synchronized (Waiting.class){
                try{
                    Waiting.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

//该线程在Blocked.class实例上枷锁后，不会释放该锁
class Blocked implements Runnable{
    @SneakyThrows
    @Override
    public void run() {
        synchronized (Blocked.class) {
            while (true) {
                Thread.sleep(1000000);
            }
        }
    }
}
