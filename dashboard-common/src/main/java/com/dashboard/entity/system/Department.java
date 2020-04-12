package com.dashboard.entity.system;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 部门实体
 * @date 2020/4/12 19:27
 **/
public class Department extends BaseDO implements Serializable {

    private static final long serialVersionUID = -2086262303936795844L;

    /**
     * 部门ID
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("部门ID")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    @ApiModelProperty("部门名称")
    private String name;

}
