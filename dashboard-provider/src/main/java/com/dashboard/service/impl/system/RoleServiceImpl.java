package com.dashboard.service.impl.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.system.RoleMapper;
import com.dashboard.service.system.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author konglinghui
 * @description 角色管理接口
 * @date 2020/4/12 10:36
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
}
