package com.dashboard.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 定时任务
 * @date 2020/5/16 13:33
 **/
public class MyJob extends QuartzJobBean implements  Serializable {

    private static final long serialVersionUID = 8814702613123681357L;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务执行ing");
    }
}
