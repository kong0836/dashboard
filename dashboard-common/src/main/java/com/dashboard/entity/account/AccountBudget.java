package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author konglinghui
 * @description 消费预算实体
 * @date 2020/4/18 21:35
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "account_budget")
public class AccountBudget extends BaseDO implements Serializable {

    private static final long serialVersionUID = 5274555393847892683L;

    /**
     * 主键ID
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    @ApiModelProperty("分类ID")
    private Long categoryId;

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

    /**
     * 分类名称
     */
    @Transient
    private String categoryName;
}
