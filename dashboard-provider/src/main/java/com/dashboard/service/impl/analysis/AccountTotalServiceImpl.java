package com.dashboard.service.impl.analysis;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.analysis.vo.AccountAnalysisVO;
import com.dashboard.mapper.analysis.AccountTotalMapper;
import com.dashboard.service.analysis.AccountTotalService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 消费汇总服务
 * @date 2020/5/22 19:13
 **/
@Service
public class AccountTotalServiceImpl implements AccountTotalService {

    @Autowired
    private AccountTotalMapper accountTotalMapper;

    @Override
    public void findAccountTotal(AccountAnalysisVO accountAnalysisVO) {
        //TODO ++
    }
}
