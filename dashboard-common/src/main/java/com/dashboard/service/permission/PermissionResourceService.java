package com.dashboard.service.permission;

import com.dashboard.mapper.permission.PermissionResource;

/**
 * @author konglinghui
 * @description 资源相关接口
 * @date 2020/3/16 19:57
 **/
public interface PermissionResourceService {

    /**
     * 新增资源
     *
     * @param permissionResource
     */
    void insertPermissionResource(PermissionResource permissionResource);

    /**
     * 更新资源
     *
     * @param permissionResource
     */
    void updatePermissionResource(PermissionResource permissionResource);

    /**
     * 删除资源
     *
     * @param permissionResource
     */
    void deletePermissionResource(PermissionResource permissionResource);
}
