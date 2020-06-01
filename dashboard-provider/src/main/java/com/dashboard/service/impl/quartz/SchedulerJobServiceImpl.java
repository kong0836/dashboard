package com.dashboard.service.impl.quartz;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.entity.Page;
import com.dashboard.entity.quartz.SchedulerJob;
import com.dashboard.entity.quartz.SchedulerJobPageInfo;
import com.dashboard.mapper.quartz.SchedulerJobMapper;
import com.dashboard.service.quartz.SchedulerJobService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

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

    @Override
    public Page<SchedulerJob> selectSchedulerJobList(SchedulerJobPageInfo schedulerJobPageInfo) {
        PageHelper.startPage(schedulerJobPageInfo);
        // 查询条件
        Condition condition = new Condition(SchedulerJob.class);
        List<SchedulerJob> schedulerJobList = schedulerJobMapper.selectByCondition(condition);
        PageInfo<SchedulerJob> pageInfo = new PageInfo<>(schedulerJobList);
        Page<SchedulerJob> page = new Page<>();
        BeanUtils.copyProperties(pageInfo, page);

        return page;
    }

    @Override
    public SchedulerJob findSchedulerJobById(String id) {
        return schedulerJobMapper.selectByPrimaryKey(id);
    }
}
