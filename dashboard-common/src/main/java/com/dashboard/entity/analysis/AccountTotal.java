package com.dashboard.entity.analysis;

import com.dashboard.common.entity.BaseDO;
import com.dashboard.enums.account.AccountCategoryTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 消费记录汇总表
 * @date 2020/5/16 18:51
 **/

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel
@Table(name = "analysis_account_total")
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
     * 消费日期：默认当天
     *
     * @JsonFormat 解决后台传递到前台时时间格式的问题
     * @DateTimeFormat 接收前台传递的时间
     */
    @Column(name = "consumer_date")
    @ApiModelProperty("消费日期：默认当天")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp consumerDate;

    /**
     * 消费类型: 1-收入 2-支出
     *
     * @see AccountCategoryTypeEnum
     */
    @Column(name = "type")
    @ApiModelProperty("消费类型: 1-收入 2-支出")
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
