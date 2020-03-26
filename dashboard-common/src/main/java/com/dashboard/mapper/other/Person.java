package com.dashboard.mapper.other;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019-12-2
 */
@Data
@ApiModel
public class Person extends BaseDO implements Serializable {

    private static final long serialVersionUID = 4248795554969207916L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String id;

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty("性别")
    private Integer gender;

    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 照片
     */
    @ApiModelProperty("照片")
    private String picture;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;
}