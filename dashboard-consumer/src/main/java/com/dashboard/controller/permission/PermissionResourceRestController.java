package com.dashboard.controller.permission;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.service.permission.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description TODO
 * @date 2020/3/16 19:56
 **/
@RestController
@RequestMapping("/menu")
public class PermissionResourceRestController {

    @Reference
    private MenuService menuService;


}
