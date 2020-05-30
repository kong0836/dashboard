package com.dashboard.entity.quartz;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 定时任务实体类
 * @date 2020/5/14 19:34
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "qrtz_schedule_job")
public class SchedulerJob extends BaseDO implements Serializable {

    private static final long serialVersionUID = 5583475274949343407L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("主键")
    private Long id;

    /**
     * job名称
     */
    @Column(name = "job_name")
    @ApiModelProperty("job名称")
    private String jobName;

    /**
     * job分组名称
     */
    @Column(name = "job_group")
    @ApiModelProperty("job分组名称")
    private String jobGroup;

    /**
     * 触发器名称
     */
    @Column(name = "trigger_name")
    @ApiModelProperty("触发器名称")
    private String triggerName;

    /**
     * 触发器分组名称
     */
    @Column(name = "trigger_group")
    @ApiModelProperty("触发器分组名称")
    private String triggerGroup;

    /**
     * 需要执行的job.class
     */
    @Column(name = "job_class")
    @ApiModelProperty("需要执行的job.class")
    private String jobClass;

    /**
     * cron表达式
     */
    @Column(name = "cron")
    @ApiModelProperty("cron表达式")
    private String cron;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
}
