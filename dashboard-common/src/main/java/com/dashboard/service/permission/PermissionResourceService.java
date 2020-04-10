package com.dashboard.service.permission;

import com.dashboard.entity.permission.PermissionResource;
import com.dashboard.entity.permission.PermissionResourceTreeVO;
import com.dashboard.entity.permission.ResourceNavTreeVO;
import com.dashboard.entity.permission.ResourceTreeVO;

import java.util.List;

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
    void updateResourceById(PermissionResource permissionResource);

    /**
     * 查询所有可用资源并用树结构展示
     *
     * @return
     */
    List<ResourceTreeVO> findResourceTreeList();

    /**
     * 导航菜单树
     *
     * @return
     */
    List<ResourceNavTreeVO> findNavResourceTreeList();

    /**
     * 资源列表数据
     *
     * @param permissionResource
     * @return
     */
    List<PermissionResourceTreeVO> findResourceList(PermissionResource permissionResource);

    /**
     * 查询资源数据
     *
     * @param id
     * @return
     */
    PermissionResource findResourceById(String id);
}
