package com.dashboard.mapper;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019-12-2
 */
@Data
@ApiModel
public class User extends BaseBO implements Serializable {

    private static final long serialVersionUID = 4248795554969207916L;

    /**
     *
     */
    @ApiModelProperty("")
    private String userId;

    /**
     *
     */
    @ApiModelProperty("")
    private String roleId;

    /**
     *
     */
    @ApiModelProperty("")
    private String userName;

    /**
     *
     */
    @ApiModelProperty("")
    private String password;

    /**
     *
     */
    @ApiModelProperty("")
    private Integer isDeleted;
}