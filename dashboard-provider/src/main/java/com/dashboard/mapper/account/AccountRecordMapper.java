package com.dashboard.mapper.account;

import com.dashboard.common.mapper.BaseMapper;
import com.dashboard.entity.account.AccountRecord;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author konglinghui
 * @description 消费记录
 * @date 2020/4/18 22:47
 **/
public interface AccountRecordMapper extends BaseMapper<AccountRecord> {

    /**
     * 查询每个消费分类的汇总数据
     *  @param type     消费分类类型
     * @param personId 用户id
     * @return
     */
    List<Map<String, BigDecimal>> selectTotalByPersonId(@Param("type") Integer type,
                                                        @Param("personId") String personId);
}
