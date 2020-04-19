package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    @Column(name = "parent_id")
    @ApiModelProperty("上级主键ID")
    private Long personId;

    /**
     * 分类ID
     */
    @Column(name = "category_id")
    @ApiModelProperty("分类ID")
    private Long categoryId;

    /**
     * 收支类型: 1-收入，2-支出
     */
    @Column(name = "type")
    @ApiModelProperty("收支类型: 1-收入，2-支出")
    private Long type;

    /**
     * 金额: 单位(分)
     */
    @Column(name = "amount")
    @ApiModelProperty("金额: 单位(分)")
    private String amount;

    /**
     * 备注
     */
    @Column(name = "remark")
    @ApiModelProperty("备注")
    private String remark;
}
