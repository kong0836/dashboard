package com.dashboard.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 树结构基类
 * @date 2020/4/5 9:53
 **/
@Data
public class BaseTreeVO<T> implements Serializable {

    private static final long serialVersionUID = 5305629264937763111L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 上级主键id
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;

    /**
     * 下级
     */
    private List<T> children;
}
