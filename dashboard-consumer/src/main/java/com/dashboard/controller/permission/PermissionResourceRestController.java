package com.dashboard.controller.permission;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.entity.permission.PermissionResource;
import com.dashboard.service.permission.PermissionResourceService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description 资源相关接口
 * @date 2020/3/16 19:56
 **/
@Api(tags = "资源相关接口")
@RestController
@RequestMapping("/permission/resource")
public class PermissionResourceRestController {

    @Reference
    private PermissionResourceService permissionResourceService;

    /**
     * 新增资源
     *
     * @param permissionResource
     * @return
     */
    @ApiOperation("新增资源")
    @PostMapping("/createResource")
    public RestResult createResource(@RequestBody PermissionResource permissionResource) {

        permissionResource.setId(SnowflakeIdWorker.generateId());

        permissionResourceService.insertPermissionResource(permissionResource);

        return RestResult.success();
    }

    /**
     * 更新资源
     *
     * @param permissionResource
     * @return
     */
    @ApiOperation("更新资源")
    @PostMapping("/updateResource")
    public RestResult updateResource(@RequestBody PermissionResource permissionResource) {

        permissionResourceService.updatePermissionResource(permissionResource);

        return RestResult.success();
    }

    /**
     * 删除资源
     *
     * @param permissionResource
     * @return
     */
    @ApiOperation("删除资源")
    @PostMapping("/deleteResource")
    public RestResult deleteResource(@RequestBody PermissionResource permissionResource) {

        permissionResourceService.deletePermissionResource(permissionResource);

        return RestResult.success();
    }
}