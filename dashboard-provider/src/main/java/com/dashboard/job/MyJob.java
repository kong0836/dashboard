package com.dashboard.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 定时任务
 * @date 2020/5/16 13:33
 **/
public class MyJob implements Job, Serializable {

    private static final long serialVersionUID = 8814702613123681357L;


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务执行ing");
    }
}
