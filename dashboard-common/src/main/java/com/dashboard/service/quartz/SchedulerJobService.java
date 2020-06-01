package com.dashboard.service.quartz;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.entity.quartz.SchedulerJobPageInfo;

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

    /**
     * 查询定时任务列表信息
     *
     * @param schedulerJobPageInfo
     * @return
     */
    Page<SchedulerJob> selectSchedulerJobList(SchedulerJobPageInfo schedulerJobPageInfo);

    /**
     * 查询定时任务
     *
     * @param id
     * @return
     */
    SchedulerJob findSchedulerJobById(String id);
}
