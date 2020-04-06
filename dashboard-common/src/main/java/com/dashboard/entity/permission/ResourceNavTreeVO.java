package com.dashboard.entity.permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 导航菜单树实体
 * @date 2020/4/6 0:02
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceNavTreeVO extends ResourceTreeVO implements Serializable {

    private static final long serialVersionUID = 1031939165649290386L;

    /**
     * 资源对应URL
     */
    private String url;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型: 1-目录 2-资源 3-按钮
     */
    private Integer type;
}