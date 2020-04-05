package com.dashboard.entity.permission;

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
 * @description 资源资源实体
 * @date 2020/3/15 23:42
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
@Table(name = "permission_resource")
public class PermissionResource extends BaseDO implements Serializable {

    private static final long serialVersionUID = -3079489125879591467L;

    /**
     * 主键
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("资源主键id")
    private Long id;

    /**
     * 上级资源主键id
     */
    @Column(name = "parent_id")
    @ApiModelProperty("上级资源主键id")
    private Long parentId;

    /**
     * 资源名称
     */
    @Column(name = "name")
    @ApiModelProperty("资源名称")
    private String name;

    /**
     * 资源对应URL
     */
    @Column(name = "url")
    @ApiModelProperty("资源对应URL")
    private String url;

    /**
     * 授权码
     */
    @Column(name = "code")
    @ApiModelProperty("授权码")
    private String code;

    /**
     * 类型: 1-目录 2-资源 3-按钮
     */
    @Column(name = "type")
    @ApiModelProperty("类型: 1-目录 2-资源 3-按钮")
    private Integer type;

    /**
     * 图标
     */
    @Column(name = "icon")
    @ApiModelProperty("图标")
    private String icon;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;

    /**
     * 排序号
     */
    @Column(name = "order_no")
    @ApiModelProperty("'排序号'")
    private Integer orderNo;

    /**
     * 描述
     */
    @Column(name = "description")
    @ApiModelProperty("描述")
    private String description;

}