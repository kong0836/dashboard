package com.dashboard.controller.permission;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.enums.StatusEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.permission.PermissionResource;
import com.dashboard.entity.permission.PermissionResourceVO;
import com.dashboard.entity.permission.ResourceNavTreeVO;
import com.dashboard.entity.permission.ResourceTreeVO;
import com.dashboard.service.permission.PermissionResourceService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 * @author konglinghui
 * @description 资源相关接口
 * @date 2020/3/16 19:56
 **/
@Api(tags = "资源相关接口")
@RestController
@RequestMapping("/permission/resource")
public class PermissionResourceRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionResourceRestController.class);

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

        Timestamp currentTimeStamp = DateTimeUtils.currentTimeStamp();
        permissionResource.setCreateTime(currentTimeStamp);
        permissionResource.setCreateBy("0");
        permissionResource.setUpdateTime(currentTimeStamp);
        permissionResource.setUpdateBy("0");

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

        permissionResourceService.updateResourceById(permissionResource);

        return RestResult.success();
    }

    /**
     * 禁用资源
     *
     * @param id 资源主键id
     * @return
     */
    @ApiOperation("禁用资源")
    @PostMapping("/disabledResource/{id}")
    public RestResult disabledResource(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        PermissionResource permissionResource = permissionResourceService.findResourceById(id);
        permissionResource.setStatus(StatusEnum.OFF.getCode());
        permissionResource.setUpdateTime(DateTimeUtils.currentTimeStamp());
        permissionResourceService.updateResourceById(permissionResource);

        return RestResult.success();
    }

    /**
     * 启用资源
     *
     * @param id 资源主键id
     * @return
     */
    @ApiOperation("启用资源")
    @PostMapping("/enabledResource/{id}")
    public RestResult enabledResource(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        PermissionResource permissionResource = permissionResourceService.findResourceById(id);
        permissionResource.setStatus(StatusEnum.ON.getCode());
        permissionResource.setUpdateTime(DateTimeUtils.currentTimeStamp());
        permissionResourceService.updateResourceById(permissionResource);

        return RestResult.success();
    }

    /**
     * 资源树-新增资源使用
     *
     * @return
     */
    @ApiModelProperty("资源树-新增资源使用")
    @GetMapping("/findResourceTreeList")
    public RestResult findResourceTreeList() {
        List<ResourceTreeVO> resourceTreeList = permissionResourceService.findResourceTreeList();

        return RestResult.success(resourceTreeList);
    }

    /**
     * 导航菜单树
     *
     * @return
     */
    @ApiModelProperty("导航菜单树")
    @GetMapping("/findNavResourceTreeList")
    public RestResult findNavResourceTreeList() {
        List<ResourceNavTreeVO> resourceNavTreeList = permissionResourceService.findNavResourceTreeList();

        return RestResult.success(resourceNavTreeList);
    }

    /**
     * 资源列表数据
     *
     * @return
     */
    @ApiModelProperty("资源列表数据")
    @PostMapping("/findResourceList")
    public RestResult findResourceList(@RequestBody PermissionResource permissionResource) {
        if (Objects.isNull(permissionResource)) {
            permissionResource = new PermissionResource();
        }
        List<PermissionResourceVO> resourceList = permissionResourceService.findResourceList(permissionResource);

        return RestResult.success(resourceList);
    }

    /**
     * 查询资源数据
     *
     * @return
     */
    @ApiModelProperty("查询资源数据")
    @GetMapping("/findResourceById/{id}")
    public RestResult findResourceById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        PermissionResource permissionResource = permissionResourceService.findResourceById(id);

        return RestResult.success(permissionResource);
    }
}