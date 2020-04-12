package com.dashboard.entity.system;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 角色实体
 * @date 2020/4/12 10:29
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseDO implements Serializable {

    private static final long serialVersionUID = -6961187601045808344L;

    /**
     * 角色ID
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("角色ID")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "name")
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;

    /**
     * 描述
     */
    @Column(name = "description")
    @ApiModelProperty("描述")
    private String description;
}
