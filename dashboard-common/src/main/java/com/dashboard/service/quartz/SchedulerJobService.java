package com.dashboard.service.quartz;

import com.dashboard.entity.quartz.SchedulerJob;

/**
 * @author konglinghui
 * @description 定时任务服务
 * @date 2020/5/30 19:54
 **/
public interface SchedulerJobService {

    /**
     * 新增
     *
     * @param schedulerJob
     */
    void insertSchedulerJob(SchedulerJob schedulerJob);

    /**
     * 更新
     *
     * @param schedulerJob
     */
    void updateSchedulerJob(SchedulerJob schedulerJob);
}
