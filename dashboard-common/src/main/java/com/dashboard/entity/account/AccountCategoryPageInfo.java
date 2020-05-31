package com.dashboard.entity.account;

import com.dashboard.enums.account.AccountCategoryTypeEnum;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费分类分页实体
 * @date 2020/4/13 10:47
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
public class AccountCategoryPageInfo extends PageInfo<AccountCategory> implements Serializable {

    private static final long serialVersionUID = 1955348804933995641L;

    /**
     * 用户名
     */
    @Column(name = "name")
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 消费类型: 1-收入 2-支出
     *
     * @see AccountCategoryTypeEnum
     */
    @Column(name = "type")
    @ApiModelProperty("消费类型: 1-收入 2-支出")
    private Integer type;
}
