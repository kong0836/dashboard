package com.dashboard.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.service.system.RoleService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
