package com.laoma.xianChengChi.test;

import lombok.NonNull;

import java.util.concurrent.*;

/**
  * @description 
  * @author majinming@xiaomi.com
  * @date 2021年 03月18日 16:18
  */
 public class ThreadPoolTest {
 /**
  * 获取cpu核心线程数也就是计算资源。
  * cpu密集型计算推荐设置线程池核心线程数为N，也就是和cpu的线程数相同，可以尽可能低避免线程间上下文切换
 */
 private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int CORE_POOL_SIZE = Math.max(4, Math.min(CPU_COUNT - 1, 5));
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 2;
  private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<>(10);
  private static  ThreadPoolExecutor THREAD_POOL_EXECUTOR;

  //一共执行20个任务 ,核心线程数是4，最大核心线程数是10，目前加入的runnable20个(相当于20个任务），
  //20个任务需要执行，但是核心线程数只有4个，还有16个任务，由于LinkedBlockingQueue队列是最大存放的任务为10个，
 // 队列满了，则会创建新的线程去执行任务，这个时候最大线程是10， 非核心线LinkedBlockingQueue数还有6个，这时候会开6个线程去执行，
 // 目前达到10个最大线程数，此时队列里面还有10个。正好满足队列的大小

 static {
  System.out.println(CPU_COUNT);
   System.out.println("核心线程数=" + CORE_POOL_SIZE);
   System.out.println("最大线程数=" + MAXIMUM_POOL_SIZE);

   ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
           /**
            * 核心线程数
            */
           CORE_POOL_SIZE,
           /**
            * 线程池中最大的线程数
            */
           MAXIMUM_POOL_SIZE,
           /**
            * 线程的存活时间，没事干的时候，空闲的时间
            */
           60,
           /**
            * 线程存活时间的单位
            */
           TimeUnit.SECONDS,
           /**
            * 线程缓存队列
            */
           sPoolWorkQueue,
           /**
            * 线程创建工厂，如果线程池需要创建线程会调用newThread来创建
            * 指定创建线程的方式
            */
           new ThreadFactory() {

            @Override
            public Thread newThread(@NonNull Runnable r) {
             Thread thread = new Thread(r);
             thread.setDaemon(false);

             return thread;
            }
           }
//           new DefaultThreadFactory()//由系统默认实现的线程工厂
           );
   //核心线程也会被超时回收
   threadPoolExecutor.allowCoreThreadTimeOut(true);
   THREAD_POOL_EXECUTOR = threadPoolExecutor;
  }

  public static void main(String[] args) {
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
    Future future= THREAD_POOL_EXECUTOR.submit(metialThread);

//    THREAD_POOL_EXECUTOR.execute(runnable);
   }
  }
 }

