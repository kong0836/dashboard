package com.dashboard.service.account;

import com.dashboard.entity.account.AccountRecord;

import java.util.List;

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
     * @return
     */
    List<AccountRecord> findAccountRecordList();
}
