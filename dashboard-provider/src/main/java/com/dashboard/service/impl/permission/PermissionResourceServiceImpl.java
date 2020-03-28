package com.dashboard.service.impl.permission;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.permission.PermissionResourceMapper;
import com.dashboard.entity.permission.PermissionResource;
import com.dashboard.service.permission.PermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 资源相关接口
 * @date 2020/3/16 22:40
 **/
@Service
public class PermissionResourceServiceImpl implements PermissionResourceService {

    @Autowired
    private PermissionResourceMapper permissionResourceMapper;

    @Override
    public void insertPermissionResource(PermissionResource permissionResource) {
        permissionResourceMapper.insert(permissionResource);
    }

    @Override
    public void updatePermissionResource(PermissionResource permissionResource) {
        permissionResourceMapper.updateByPrimaryKey(permissionResource);
    }

    @Override
    public void deletePermissionResource(PermissionResource permissionResource) {
        permissionResourceMapper.updateByPrimaryKey(permissionResource);
    }
}
