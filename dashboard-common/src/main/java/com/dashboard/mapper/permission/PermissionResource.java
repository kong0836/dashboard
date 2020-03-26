package com.dashboard.mapper.permission;

import com.dashboard.common.entity.BaseDO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 菜单资源实体
 * @date 2020/3/15 23:42
 **/
@Data
public class PermissionResource extends BaseDO implements Serializable {

    private static final long serialVersionUID = -3079489125879591467L;

    /**
     * 主键
     */
    private String menuId;

    /**
     * 上级菜单主键
     */
    private String parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单对应URL
     */
    private String url;

    /**
     * 授权码
     */
    private String code;

    /**
     * 类型: 1-目录 2-菜单 3-按钮
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;
}