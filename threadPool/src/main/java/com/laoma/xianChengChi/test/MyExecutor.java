package com.laoma.xianChengChi.test;

import java.util.concurrent.*;

/**
  * @description 已经被实现好的功能线程池
  * @author majinming@xiaomi.com
  * @date 2021年 03月18日 15:47
  */
public class MyExecutor {
    public static void main(String[] args){
        /**　定长线程池
         * 　 特点：只有核心线程，线程数量固定，执行完立即回收，任务队列为链表结构的有界队列。
         *    应用场景：控制线程最大并发数。
         */
//        int i  = 1;
        // 1. 创建定长线程池对象 & 设置线程池线程数量固定为3
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        // 2. 创建好Runnable类线程对象 & 需执行的任务

        Runnable task =new Runnable(){
            @Override
            public void run() {
                System.out.println("执行任务啦");
            }
        };
        // 3. 向线程池提交任务
        fixedThreadPool.execute(task);

        for (int i = 0; i < 20; i++) {
            String s ="你好--"+ i;
            TestMetialThread metialThread = new TestMetialThread(s);
//    Runnable runnable = new Runnable() {
//     @Override
//     public void run() {
//      try {
//       Thread.sleep(1000);
//      } catch (InterruptedException e) {
//       e.printStackTrace();
//      }
//      System.out.println("执行完毕" + Thread.currentThread().getName());
//     }
//    };
            //丢给线程池去执行
            Future future= fixedThreadPool.submit(metialThread);

//    THREAD_POOL_EXECUTOR.execute(runnable);
        }
    }

}

