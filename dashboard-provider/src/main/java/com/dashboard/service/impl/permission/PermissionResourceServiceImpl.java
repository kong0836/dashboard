package com.dashboard.service.impl.permission;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.constants.DashboardConstants;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.entity.permission.ResourceTreeVO;
import com.dashboard.mapper.permission.PermissionResourceMapper;
import com.dashboard.entity.permission.PermissionResource;
import com.dashboard.service.permission.PermissionResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Override
    public List<ResourceTreeVO> findResourceTreeList() {
        List<ResourceTreeVO> resourceTreeVOList = new ArrayList<>();

        ResourceTreeVO rootResourceTreeVO = new ResourceTreeVO();
        rootResourceTreeVO.setId(DashboardConstants.ZERO_LONG.toString());
        rootResourceTreeVO.setName("根节点");
        resourceTreeVOList.add(rootResourceTreeVO);

        // 获取所有可用资源
        Condition condition = new Condition(PermissionResource.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("status", StatusEnum.ON.getCode());
        List<PermissionResource> resourceList = permissionResourceMapper.selectByCondition(condition);

        // 将所有的数据，以键值对的形式装入map中
        Map<Long, ResourceTreeVO> resourceTreeVOMap = new HashMap<>();
        for (PermissionResource resource : resourceList) {
            ResourceTreeVO resourceTreeVO = new ResourceTreeVO();
            Long id = resource.getId();
            resourceTreeVO.setId(id.toString());
            resourceTreeVO.setParentId(resource.getParentId().toString());
            resourceTreeVO.setName(resource.getName());

            resourceTreeVOMap.put(id, resourceTreeVO);
        }

        resourceList.forEach(resource -> {
            Long id = resource.getId();
            Long parentId = resource.getParentId();
            ResourceTreeVO resourceTreeVO = resourceTreeVOMap.get(id);
            if (DashboardConstants.ZERO_LONG.equals(parentId) && Objects.nonNull(resourceTreeVO)) {
                // 一级资源
                resourceTreeVOList.add(resourceTreeVO);
            } else {
                // 子级通过父id获取到父级的类型
                ResourceTreeVO parentResourceTreeVO = resourceTreeVOMap.get(parentId);
                if (Objects.nonNull(parentResourceTreeVO)) {
                    if (CollectionUtils.isEmpty(parentResourceTreeVO.getChildren())) {
                        parentResourceTreeVO.setChildren(new ArrayList<>());
                    }
                    // 父级获得子级，再将子级放到对应的父级中
                    parentResourceTreeVO.getChildren().add(resourceTreeVO);
                }
            }
        });

        return resourceTreeVOList;
    }
}
