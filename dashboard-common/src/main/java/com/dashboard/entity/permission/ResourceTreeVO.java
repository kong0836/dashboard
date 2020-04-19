package com.dashboard.entity.permission;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 资源菜单树
 * @date 2020/4/5 9:53
 **/
@Data
public class ResourceTreeVO implements Serializable {

    private static final long serialVersionUID = 5305629264937763111L;

    /**
     * 主键
     */
    private String id;

    /**
     * 上级资源主键id
     */
    private String parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 下级资源
     */
    private List<ResourceTreeVO> children;
}
