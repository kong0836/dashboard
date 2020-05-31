package com.dashboard.service.impl.permission;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.entity.Page;
import com.dashboard.entity.system.Role;
import com.dashboard.entity.system.RolePageInfo;
import com.dashboard.mapper.permission.RoleMapper;
import com.dashboard.service.permission.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author konglinghui
 * @description 角色管理接口
 * @date 2020/4/12 10:36
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void insertRole(Role role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public void updateRole(Role role) {
        roleMapper.updateByPrimaryKey(role);
    }

    @Override
    public Page<Role> findRoleList(RolePageInfo rolePageInfo) {
        PageHelper.startPage(rolePageInfo);

        Role role = new Role();
        BeanUtils.copyProperties(rolePageInfo,role);

        List<Role> roleList = roleMapper.select(role);
        PageInfo<Role> pageInfo = new PageInfo<>(roleList);
        Page<Role> page = new Page<>();
        BeanUtils.copyProperties(pageInfo,page);

        return page;
    }

    @Override
    public Role findRoleById(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);

        return role;
    }
}
