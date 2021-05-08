package com.laoma.test.yanshirenwu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;

/**
  * @description 定时任务，使用接口SchedulingConfigurer
  * @author majinming@xiaomi.com
  * @date 2021年 03月22日 16:36
  */

 @Configuration
 @ComponentScan(value = "com.es.evaluation_teaching_wp.utils")
 @EnableScheduling
 public class Config implements SchedulingConfigurer {

 /**
  * 　默认的，SchedulingConfigurer 使用的也是单线程的方式，如果需要配置多线程，则需要指定 PoolSize
 */
// @Override
//   public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//    ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
//    taskScheduler.setPoolSize(10);
//    taskScheduler.initialize();
//    taskRegistrar.setTaskScheduler(taskScheduler);
//   }

  @Override
  public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {



   taskRegistrar.addFixedRateTask(new Runnable() {
    @Override
    public void run() {
     System.out.println("addFixedRateTask new Runnable() 定时任务执行了。");
    }
   },100);

   taskRegistrar.addTriggerTask(new Runnable() {
    @Override
    public void run() {
     System.out.println("addTriggerTask new Runnable() 定时任务执行了。");
    }
   }, new Trigger() {
    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
     // 定时任务触发，可修改定时任务的执行周期
     CronTrigger trigger = new CronTrigger("*/2 * * * * ?");
     Date nextExecDate = trigger.nextExecutionTime(triggerContext);
     return nextExecDate;
    }
   });

   //或者使用JDK 1.8的Lambda表达式
   taskRegistrar.addFixedRateTask(() -> System.out.println("Lambda表达式，执行定时任务1: " + new Date()), 1000);
   TriggerTask triggrtTask = new TriggerTask( // 任务内容.拉姆达表达式
           () -> {System.out.println("Lambda表达式，执行定时任务2: " + new Date());},
           // 设置触发器，这里是一个拉姆达表达式，传入的TriggerContext类型，返回的是Date类型
           triggerContext -> {
            // 2.3 返回执行周期(Date)
            return new CronTrigger("*/2 * * * * ?").nextExecutionTime(triggerContext);
           });

   taskRegistrar.addTriggerTask(triggrtTask);

  }


 }
