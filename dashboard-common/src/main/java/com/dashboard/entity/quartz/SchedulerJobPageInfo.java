package com.dashboard.entity.quartz;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 定时任务分页参数
 * @date 2020/6/1 19:11
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class SchedulerJobPageInfo extends PageInfo<SchedulerJob> implements Serializable {

    private static final long serialVersionUID = -5138409767817237905L;

    /**
     * job名称
     */
    @ApiModelProperty("job名称")
    private String jobName;

}
