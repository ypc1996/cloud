package com.example.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author yangpengcheng
 * @ClassName MySchedule
 * @Description:
 * @date 2020/10/299:51
 */
public class MySchedule {
    public static void main(String[] args) throws SchedulerException {
        // 1、创建调度器Scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .usingJobData("count",0)
                .withIdentity("job1", "group1").build();

        Date startDate = new Date();
        startDate.setTime(startDate.getTime() + 5000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime() + 5000);

        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()
                .usingJobData("message","message trigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever()).build();
        //4、执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
