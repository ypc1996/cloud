package com.example.test;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author yangpengcheng
 * @ClassName MyJob
 * @Description:
 * @date 2020/10/299:49
 */
public class MyJob implements Job {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String printTime = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));

        Integer count= (Integer) jobExecutionContext.getJobDetail().getJobDataMap().get("count");
        count++;
        System.out.println("count的值："+count);
        jobExecutionContext.getJobDetail().getJobDataMap().put("count",count);
    }
}
