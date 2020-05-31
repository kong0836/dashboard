package com.dashboard.entity.account;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 消费分类【编辑使用】
 * @date 2020/4/25 22:15
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountCategoryVO extends AccountCategory implements Serializable {

    private static final long serialVersionUID = -5310735163141645178L;

    /**
     * 上级分类集合：从最高节点开始
     */
    private List<String> parentIdTem;
}
