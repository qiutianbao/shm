package com.jxtb.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 17-3-30
 * Time: 上午10:45
 * To change this template use File | Settings | File Templates.
 */
@SuppressWarnings("ALL")
@Service
public class JobTask {

    //每隔5分钟执行一次
    @Scheduled(cron = "0 0/5 * * * *")
    public void jobTaskTest(){
        System.out.println("每隔5分钟执行一次 task");
    }
   //每隔10秒执行一次
  /*  @Scheduled(cron = "0/10 * * * * *")
    public void jobTaskTest(){
        System.out.println("每隔10秒执行一次 task");
    }*/

}
