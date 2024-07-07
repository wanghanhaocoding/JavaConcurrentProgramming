package com.wanghanhao.concurrent;

/**
 * @author wanghanhao
 * @version 1.0
 * @description: Thread.sleep()是否会释放CPU？是
 * @date 2024/7/7 10:08
 */
public class SleepRelaseCPU {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new SubThread(), "Daemon Thread!" + i);
            thread.start();
        }
    }
    static class SubThread implements Runnable{

        @Override
        public void run() {
            try{
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println("FINISH!");
            }
        }
    }
}
