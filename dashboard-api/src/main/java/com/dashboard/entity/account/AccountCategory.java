package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import com.dashboard.enums.account.AccountCategoryTypeEnum;
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
 * @description 消费分类实体
 * @date 2020/4/18 21:35
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "account_category")
public class AccountCategory extends BaseDO implements Serializable {

    private static final long serialVersionUID = 5274555393847892683L;

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
    private Long parentId;

    /**
     * 分类名称
     */
    @Column(name = "name")
    @ApiModelProperty("分类名称")
    private String name;

    /**
     * 消费类型: 1-收入 2-支出
     *
     * @see AccountCategoryTypeEnum
     */
    @Column(name = "type")
    @ApiModelProperty("消费类型: 1-收入 2-支出")
    private Integer type;

    /**
     * 图标
     */
    @Column(name = "icon")
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 排序号
     */
    @Column(name = "order_no")
    @ApiModelProperty("排序号")
    private Integer orderNo;

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
