package com.dashboard.service.system;

import com.dashboard.entity.system.Role;

import java.util.List;

/**
 * @author konglinghui
 * @description 角色管理接口
 * @date 2020/4/12 10:34
 **/
public interface RoleService {

    /**
     * 新增角色
     *
     * @param role
     */
    void insertRole(Role role);

    /**
     * 更新角色
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 查询角色列表
     *
     * @param role
     * @return
     */
    List<Role> findRoleList(Role role);

    /**
     * 查询角色信息
     *
     * @param id
     * @return
     */
    Role findRoleById(String id);
}
