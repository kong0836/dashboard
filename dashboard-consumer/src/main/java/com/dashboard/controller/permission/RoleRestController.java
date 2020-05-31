package com.dashboard.controller.permission;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.system.Role;
import com.dashboard.entity.system.RolePageInfo;
import com.dashboard.service.permission.RoleService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author konglinghui
 * @description 角色管理接口
 * @date 2020/4/12 10:32
 **/
@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/role/rest")
public class RoleRestController {

    @Reference
    private RoleService roleService;

    /**
     * 新建角色
     *
     * @param role
     * @return
     */
    @ApiOperation("新建角色")
    @PostMapping("/createRole")
    public RestResult createRole(@RequestBody Role role) {

        role.setId(SnowflakeIdWorker.generateId());
        role.setCreateTime(DateTimeUtils.currentTimeStamp());
        role.setCreateBy("0");
        role.setUpdateBy("0");

        roleService.insertRole(role);

        return RestResult.success();
    }

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    @ApiOperation("更新角色")
    @PostMapping("/updateRole")
    public RestResult updateRole(@RequestBody Role role) {
        roleService.updateRole(role);

        return RestResult.success();
    }

    /**
     * 查询角色列表
     *
     * @param rolePageInfo
     * @return
     */
    @ApiOperation("查询角色列表")
    @PostMapping("/findRoleList")
    public RestResult findRoleList(@RequestBody RolePageInfo rolePageInfo) {
        if (Objects.isNull(rolePageInfo)) {
            rolePageInfo = new RolePageInfo();
        }
        if (StringUtils.isBlank(rolePageInfo.getName())) {
            rolePageInfo.setName(null);
        }

        Page<Role> page = roleService.findRoleList(rolePageInfo);

        return RestResult.success(page);
    }

    /**
     * 查询角色信息
     *
     * @param id
     * @return
     */
    @ApiOperation("查询角色信息")
    @GetMapping("/findRoleById/{id}")
    public RestResult findRoleById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        Role role = roleService.findRoleById(id);

        return RestResult.success(role);
    }
}
