package com.dashboard.entity.permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 资源实体【编辑使用】
 * @date 2020/4/10 17:54
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionResourceVO extends PermissionResource implements Serializable {

    private static final long serialVersionUID = -7441174829920015686L;

    /**
     * 上级资源集合：从最高节点开始
     */
    private List<String> parentIdTem;
}
