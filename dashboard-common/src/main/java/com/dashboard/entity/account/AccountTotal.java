package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import com.dashboard.enums.account.AccountTotalTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author konglinghui
 * @description 消费记录汇总表
 * @date 2020/5/16 18:51
 **/

@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "account_total")
public class AccountTotal extends BaseDO implements Serializable {

    private static final long serialVersionUID = -2236432232169514686L;


    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("主键ID")
    private Long id;
    /**
     * 上级主键ID
     */
    @Column(name = "person_id")
    @ApiModelProperty("上级主键ID")
    private Long personId;


    /**
     * 分类ID
     */
    @Column(name = "category_id")
    @ApiModelProperty("分类ID")
    private Long categoryId;

    /**
     * 汇总方式: 日、周、月、季度、半年、年
     *
     * @see AccountTotalTypeEnum
     */
    @Column(name = "type")
    @ApiModelProperty("汇总方式: 日、周、月、季度、半年、年")
    private Integer type;

    /**
     * 金额: 单位(分)
     */
    @Column(name = "amount")
    @ApiModelProperty("金额: 单位(分)")
    private BigDecimal amount;

    /**
     * 状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("状态: 0-启用 1-禁用")
    private Integer status;

    /**
     * 备注
     */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
}
