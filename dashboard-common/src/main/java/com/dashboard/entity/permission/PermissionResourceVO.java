package com.dashboard.entity.permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 资源
 * @date 2020/4/6 18:12
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class PermissionResourceVO extends PermissionResource implements Serializable {

    private static final long serialVersionUID = -7441174829920015686L;

    /**
     * 主键id字符串
     */
    private String idString;

    /**
     * 主键id字符串
     */
    private String parentIdString;

    /**
     * 下级资源
     */
    private List<PermissionResourceVO> children;
}
