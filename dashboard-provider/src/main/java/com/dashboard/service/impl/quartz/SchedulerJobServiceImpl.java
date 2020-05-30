package com.dashboard.service.impl.quartz;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.mapper.quartz.SchedulerJobMapper;
import com.dashboard.service.quartz.SchedulerJobService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 定时任务服务
 * @date 2020/5/30 19:55
 **/
@Service
public class SchedulerJobServiceImpl implements SchedulerJobService {

    @Autowired
    private SchedulerJobMapper schedulerJobMapper;

    @Override
    public void insertSchedulerJob(SchedulerJob schedulerJob) {
        schedulerJobMapper.insert(schedulerJob);
    }

    @Override
    public void updateSchedulerJob(SchedulerJob schedulerJob) {
        schedulerJobMapper.updateByPrimaryKey(schedulerJob);
    }
}
