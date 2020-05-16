package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import com.dashboard.common.enums.AccountChannelEnum;
import com.dashboard.enums.account.AccountCategoryTypeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author konglinghui
 * @description 消费记录实体
 * @date 2020/4/18 22:10
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "account_record")
public class AccountRecord extends BaseDO implements Serializable {

    private static final long serialVersionUID = 3322218529420055733L;

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
     * 消费类型: 1-收入 2-支出
     *
     * @see AccountCategoryTypeEnum
     */
    @Column(name = "type")
    @ApiModelProperty("消费类型: 1-收入 2-支出")
    private Integer type;

    /**
     * 消费渠道：微信、支付宝、现金、银行app、其他
     *
     * @see AccountChannelEnum
     */
    @Column(name = "channel")
    @ApiModelProperty("消费渠道：微信、支付宝、现金、银行app、其他")
    private String channel;

    /**
     * 消费地点
     */
    @Column(name = "address")
    @ApiModelProperty("消费地点")
    private String address;

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
     * 用户名
     */
    @Transient
    private String name;

    /**
     * 分类ID集合：从最高节点开始
     */
    @Transient
    private List<String> categoryIdTem;

    /**
     * 分类名称
     */
    @Transient
    private String categoryName;
}