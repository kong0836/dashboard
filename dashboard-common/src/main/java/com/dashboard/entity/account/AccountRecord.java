package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费记录实体
 * @date 2020/4/18 22:10
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountRecord extends BaseDO implements Serializable {

    private static final long serialVersionUID = 3322218529420055733L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 上级主键ID
     */
    private Long personId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 收支类型: 1-收入，2-支出
     */
    private Long type;

    /**
     * 金额: 单位(分)
     */
    private String amount;

    /**
     * 备注
     */
    private String remark;
}
