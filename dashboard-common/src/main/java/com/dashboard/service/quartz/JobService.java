package com.dashboard.service.quartz;

import com.dashboard.entity.quartz.SchedulerJob;
import org.quartz.SchedulerException;

/**
 * @author konglinghui
 * @description 定时任务服务
 * @date 2020/5/14 19:20
 **/
public interface JobService {

    /**
     * 添加定时任务
     *
     * @param schedulerJob 定时任务信息
     * @throws SchedulerException
     */
    void insertJob(SchedulerJob schedulerJob) throws SchedulerException, ClassNotFoundException;

    /**
     * 更新定时任务
     *
     * @param schedulerJob 定时任务信息
     */
    void updateJob(SchedulerJob schedulerJob);

    /**
     * 删除定时任务
     *
     * @param schedulerJob 定时任务信息
     * @throws SchedulerException
     */
    void deleteJob(SchedulerJob schedulerJob) throws SchedulerException;

    /**
     * 查询定时任务
     */
    void selectJobList() throws SchedulerException;
}
