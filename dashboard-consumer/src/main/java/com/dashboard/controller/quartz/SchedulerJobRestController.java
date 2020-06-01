package com.dashboard.controller.quartz;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.entity.quartz.SchedulerJobPageInfo;
import com.dashboard.service.quartz.JobService;
import com.dashboard.service.quartz.SchedulerJobService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 定时任务控制器
 * @date 2020/5/14 19:39
 **/
@RestController
@RequestMapping("/scheduler/job/rest")
public class SchedulerJobRestController {

    @Reference
    private SchedulerJobService schedulerJobService;

    @Reference
    private JobService jobService;

    /**
     * 创建定时任务
     *
     * @param schedulerJob 定时任务信息
     * @return
     * @throws SchedulerException
     */
    @PostMapping("/createSchedulerJob")
    public RestResult createSchedulerJob(@RequestBody SchedulerJob schedulerJob)
            throws SchedulerException, ClassNotFoundException {
        Timestamp currentTimeStamp = DateTimeUtils.currentTimeStamp();
        schedulerJob.setCreateTime(currentTimeStamp);
        schedulerJob.setCreateBy("0");
        schedulerJob.setUpdateTime(currentTimeStamp);
        schedulerJob.setUpdateBy("0");
        schedulerJob.setId(SnowflakeIdWorker.generateId());

        schedulerJobService.insertSchedulerJob(schedulerJob);
        // 调用定时任务
        jobService.insertJob(schedulerJob);

        return RestResult.success();
    }

    /**
     * 更新定时任务信息
     *
     * @param schedulerJob 定时任务信息
     * @return
     */
    @PostMapping("/updateSchedulerJob")
    public RestResult updateSchedulerJob(@RequestBody SchedulerJob schedulerJob) {
        //TODO ++
        schedulerJobService.updateSchedulerJob(schedulerJob);
        jobService.updateJob(schedulerJob);

        return RestResult.success();
    }

    /**
     * 删除定时任务
     *
     * @param schedulerJob 定时任务信息
     * @return
     * @throws SchedulerException
     */
    @PostMapping("/deleteSchedulerJob")
    public RestResult deleteSchedulerJob(@RequestBody SchedulerJob schedulerJob) throws SchedulerException {
        //TODO ++
        jobService.deleteJob(schedulerJob);

        return RestResult.success();
    }

    /**
     * 查询所有进行中的定时任务
     *
     * @return
     * @throws SchedulerException
     */
    @PostMapping("/findSchedulerJobList")
    public RestResult findSchedulerJobList(@RequestBody SchedulerJobPageInfo schedulerJobPageInfo)
            throws SchedulerException {
        Page<SchedulerJob> page = schedulerJobService.selectSchedulerJobList(schedulerJobPageInfo);

        return RestResult.success(page);
    }

    @GetMapping("/findSchedulerJobById/{id}")
    public RestResult findSchedulerJobById(@PathVariable String id) {
        SchedulerJob schedulerJob = schedulerJobService.findSchedulerJobById(id);

        return RestResult.success(schedulerJob);
    }
}
