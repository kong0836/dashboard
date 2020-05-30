package com.dashboard.service.impl.quartz;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.service.quartz.SchedulerJobService;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @author konglinghui
 * @description 定时任务服务
 * @date 2020/5/14 19:21
 **/
@Service
public class SchedulerJobServiceImpl implements SchedulerJobService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void insertJob(SchedulerJob schedulerJob) throws SchedulerException, ClassNotFoundException {
        JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) Class.forName(schedulerJob.getJobClass()))
                .withIdentity(schedulerJob.getJobName(), schedulerJob.getJobGroup())
                .build();
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(schedulerJob.getCron());
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(schedulerJob.getTriggerName(), schedulerJob.getTriggerGroup())
                .withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void updateJob(SchedulerJob schedulerJob) {

    }

    @Override
    public void deleteJob(SchedulerJob schedulerJob) throws SchedulerException {
        TriggerKey triggerKey = TriggerKey.triggerKey(schedulerJob.getTriggerName(),
                schedulerJob.getTriggerGroup());
        scheduler.pauseTrigger(triggerKey);
        scheduler.unscheduleJob(triggerKey);
        JobKey jobKey = JobKey.jobKey(schedulerJob.getJobName(), schedulerJob.getJobGroup());
        scheduler.deleteJob(jobKey);
    }

    @Override
    public void selectJobList() throws SchedulerException {
        Set<JobKey> jobKeys = scheduler.getJobKeys(GroupMatcher.anyGroup());
    }
}
