package com.example.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author yangpengcheng
 * @ClassName HelloJob
 * @Description:
 * @date 2020/11/910:34
 */
public class HelloJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.err.println("hello world");
    }
}
