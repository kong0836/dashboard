package com.dashboard.mapper;

import org.springframework.stereotype.Repository;

/**
 * @author konglinghui
 */
@Repository
public interface UserMapper {

    /**
     * 新增用户
     *
     * @param user
     */
    void insertUser(User user);
}
