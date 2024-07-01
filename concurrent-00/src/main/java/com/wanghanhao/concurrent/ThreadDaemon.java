package com.wanghanhao.concurrent;

import sun.awt.windows.ThemeReader;

/**
 * @author wanghanhao
 * @version 1.0
 * @description: 守护线程
 * @date 2024/7/1 23:11
 */
public class ThreadDaemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonThread(), "Daemon Thread!");
        thread.setDaemon(true);//守护线程
        thread.start();
        //main线程退出
    }
    static class DaemonThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {//finally 不能保证我们的守护线程最终执行
                System.out.println("FINISH!");
            }
        }
    }
}

