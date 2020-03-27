package com.dashboard.mapper.permission;

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
 * @description 权限-角色实体
 * @date 2020/3/27 17:57
 **/
@Data
@ApiModel
@Table(name = "permission-role")
@EqualsAndHashCode(callSuper = false)
public class PermissionRole extends BaseDO implements Serializable {

    private static final long serialVersionUID = 5349233572462896295L;

    /**
     * 角色主键id
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("角色主键id")
    private Long id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    @ApiModelProperty("角色名称")
    private String roleName;

    /**
     * 描述
     */
    @Column(name = "description")
    @ApiModelProperty("描述")
    private String description;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;
}
