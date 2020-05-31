package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseTreeVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 消费分类树结构
 * @date 2020/4/22 22:39
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountCategoryTreeVO extends AccountCategory implements Serializable {

    private static final long serialVersionUID = -7048574788335324402L;

    /**
     * 子集消费分类
     */
    private List<AccountCategoryTreeVO> children;
}
