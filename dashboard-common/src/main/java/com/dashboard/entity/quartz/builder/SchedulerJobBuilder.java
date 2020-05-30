package com.dashboard.entity.quartz.builder;

import com.dashboard.entity.quartz.SchedulerJob;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 定时任务构建类【建造者模式】
 * @date 2020/5/30 19:29
 **/
public class SchedulerJobBuilder implements Serializable {

    private static final long serialVersionUID = -2038737613231964709L;

    private SchedulerJob target;

    public SchedulerJobBuilder() {
        this.target = new SchedulerJob();
    }

    public SchedulerJobBuilder id(Long id) {
        this.target.setId(id);
        return this;
    }

    public SchedulerJobBuilder jobName(String jobName) {
        this.target.setJobName(jobName);
        return this;
    }

    public SchedulerJobBuilder jobGroup(String jobGroup) {
        this.target.setJobGroup(jobGroup);
        return this;
    }

    public SchedulerJobBuilder triggerName(String triggerName) {
        this.target.setTriggerName(triggerName);
        return this;
    }

    public SchedulerJobBuilder triggerGroup(String triggerGroup) {
        this.target.setTriggerGroup(triggerGroup);
        return this;
    }

    public SchedulerJobBuilder jobClass(String jobClass) {
        this.target.setJobClass(jobClass);
        return this;
    }

    public SchedulerJobBuilder cron(String cron) {
        this.target.setCron(cron);
        return this;
    }

    public SchedulerJobBuilder status(Integer status) {
        this.target.setStatus(status);
        return this;
    }

    public SchedulerJobBuilder remark(String remark) {
        this.target.setRemark(remark);
        return this;
    }

    public SchedulerJobBuilder createTime(Timestamp createTime) {
        this.target.setCreateTime(createTime);
        return this;
    }

    public SchedulerJobBuilder createBy(String createBy) {
        this.target.setCreateBy(createBy);
        return this;
    }

    public SchedulerJobBuilder updateBy(String updateBy) {
        this.target.setUpdateBy(updateBy);
        return this;
    }

    public SchedulerJobBuilder updateTime(Timestamp updateTime) {
        this.target.setUpdateTime(updateTime);
        return this;
    }

    public SchedulerJob build() {
        return this.target;
    }
}
