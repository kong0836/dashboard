package com.dashboard.service.impl.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.entity.system.Role;
import com.dashboard.mapper.system.RoleMapper;
import com.dashboard.service.system.RoleService;
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
    public List<Role> findRoleList(Role role) {
        List<Role> roleList = roleMapper.select(role);

        return roleList;
    }

    @Override
    public Role findRoleById(String id) {
        Role role = roleMapper.selectByPrimaryKey(id);

        return role;
    }
}
