package com.dashboard.controller.quartz;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.service.quartz.SchedulerJobService;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        //TODO ++
        schedulerJobService.insertJob(schedulerJob);

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
        schedulerJobService.updateJob(schedulerJob);

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
        schedulerJobService.deleteJob(schedulerJob);

        return RestResult.success();
    }

    /**
     * 查询所有进行中的定时任务
     *
     * @return
     * @throws SchedulerException
     */
    @GetMapping("/findSchedulerList")
    public RestResult findSchedulerList() throws SchedulerException {
        schedulerJobService.selectJobList();

        return RestResult.success();
    }
}
