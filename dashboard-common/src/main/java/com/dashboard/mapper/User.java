package com.dashboard.mapper;

import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019-12-2
 */
@Data
public class User extends BaseBO implements Serializable {

    private static final long serialVersionUID = 4248795554969207916L;

    /**
     *
     */
    private String userId;

    /**
     *
     */
    private String roleId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Integer isDeleted;
}