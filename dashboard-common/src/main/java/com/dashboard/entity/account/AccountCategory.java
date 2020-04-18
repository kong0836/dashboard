package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费分类实体
 * @date 2020/4/18 21:35
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class AccountCategory extends BaseDO implements Serializable {

    private static final long serialVersionUID = 5274555393847892683L;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 上级主键ID
     */
    private Long parentId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 类型: 1-一级分类 2-二级分类 3-三级分类
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序号
     */
    private Integer orderNo;

    /**
     * 状态: 0-启用 1-禁用
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;
}
