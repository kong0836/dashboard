package com.dashboard.service.impl.permission;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.menu.MenuMapper;
import com.dashboard.service.permission.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description TODO
 * @date 2020/3/16 22:40
 **/
@Service
public class PermissionResourceServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
}
