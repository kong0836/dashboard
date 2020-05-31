package com.dashboard.service.account;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.account.AccountRecord;
import com.dashboard.entity.account.AccountRecordPageInfo;

/**
 * @author konglinghui
 * @description 消费记录
 * @date 2020/4/18 22:37
 **/
public interface AccountRecordService {

    /**
     * 新建消费记录
     *
     * @param accountRecord
     */
    void createAccountRecord(AccountRecord accountRecord);

    /**
     * 手动更新消费记录
     *
     * @param accountRecord
     */
    void updateAccountRecord(AccountRecord accountRecord);

    /**
     * 删除消费记录
     *
     * @param id 主键ID
     */
    void deleteAccountRecord(Long id);

    /**
     * 查询记录
     *
     * @param accountRecordPageInfo
     * @return
     */
    Page<AccountRecord> findAccountRecordList(AccountRecordPageInfo accountRecordPageInfo);

    /**
     * 查询消费记录
     *
     * @param id
     * @return
     */
    AccountRecord findAccountRecordById(String id);

    /**
     * 初始化消费记录汇总数据
     *
     * @param personId
     */
    void initAccountTotal(String personId);
}
