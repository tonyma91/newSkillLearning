package com.laoma.test.yanshirenwu;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
  * @description 定时任务，注解实现
  * @author majinming@xiaomi.com
  * @date 2021年 03月22日 16:18
  */
 @Component
 /**
  * 　@EnableScheduling 注解的作用是发现注解@Scheduled的任务并后台执行
  */
 @EnableScheduling//可以在启动类上注解也可以在当前文件
 public class TestJob {

 /**
  * 　@Scheduled用于标注这个方法是一个定时任务的方法cron、fixedRate、fixedDelay三个是用来调度时间的这三种方式都是设置每隔十秒执行一次
 */
 /**
  *　cron是以表达式的形式来表示时间
  */
 @Scheduled(cron = "0/10 * * * * ?")
  public void runfirst(){
   System.out.println("*first job is ok******");
  }
 /**
  * 　表示Scheduled隔多长时间调用一次，不管任务是否执行完
  */
  @Scheduled(fixedRate = 1000 * 10)
  public void runsecend(){
   System.out.println("****second job is ok******");
  }

 /**
   　fixedDelay：表示该任务执行完后隔多长时间再调用
  */
 @Scheduled(fixedDelay=1000)
  public void runThird(){
   System.out.println("********third job is ok*******");
  }
 }
/**　表达式实例
 * 　
 * “0 0 12 * * ?”                每天中午12点触发
 *
 * “0 15 10 ? * *”               每天上午10:15触发
 *
 * “0 15 10 * * ?”               每天上午10:15触发
 *
 * “0 15 10 * * ? *”             每天上午10:15触发
 *
 * “0 15 10 * * ? 2005”          2005年的每天上午10:15 触发
 *
 * “0 * 14 * * ?”                在每天下午2点到下午2:59期间的每1分钟触发
 *
 * “0 0/5 14 * * ?”              在每天下午2点到下午2:55期间的每5分钟触发
 *
 * “0 0/5 14,18 * * ?”           在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 *
 * “0 0-5 14 * * ?”              在每天下午2点到下午2:05期间的每1分钟触发
 *
 * “0 10,44 14 ? 3 WED”          每年三月的星期三的下午2:10和2:44触发
 *
 * “0 15 10 ? * MON-FRI”         周一至周五的上午10:15触发
 *
 * “0 15 10 15 * ?”              每月15日上午10:15触发
 *
 * “0 15 10 L * ?”               每月最后一日的上午10:15触发
 *
 * “0 15 10 ? * 6L”              每月的最后一个星期五上午10:15触发
 *
 * “0 15 10 ? * 6L 2002-2005”    2002年至2005年的每月的最后一个星期五上午10:15触发
 *
 * “0 15 10 ? * 6#3”             每月的第三个星期五上午10:15触发
 *
 * 0 6 * * *                     每天早上6点
 *
 * 0 /2 * *                      每两个小时
 *
 * 0 23-7/2，8 * * *             晚上11点到早上8点之间每两个小时，早上八点
 *
 * 0 11 4 * 1-3                  每个月的4号和每个礼拜的礼拜一到礼拜三的早上11点
*/
