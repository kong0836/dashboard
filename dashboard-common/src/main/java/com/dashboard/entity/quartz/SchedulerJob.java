package com.dashboard.entity.quartz;

import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 定时任务实体类
 * @date 2020/5/14 19:34
 **/
@Data
public class SchedulerJob implements Serializable {

    private static final long serialVersionUID = 5583475274949343407L;

    /**
     * job名称
     */
    private String jobName;

    /**
     * job分组名称
     */
    private String jobGroup;

    /**
     * 触发器名称
     */
    private String triggerName;

    /**
     * 触发器分组名称
     */
    private String triggerGroup;

    /**
     * 需要执行的job.class
     */
    private Class jobClass;

    /**
     * cron表达式
     */
    private String cron;
}
