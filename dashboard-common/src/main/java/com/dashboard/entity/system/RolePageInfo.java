package com.dashboard.entity.system;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 角色分页参数实体
 * @date 2020/4/13 10:47
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
public class RolePageInfo extends PageInfo<Role> implements Serializable {

    private static final long serialVersionUID = 1955348804933995641L;

    /**
     * 角色名称
     */
    @Column(name = "name")
    @ApiModelProperty("角色名称")
    private String name;
}
