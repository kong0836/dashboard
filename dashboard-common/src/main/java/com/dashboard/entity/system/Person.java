package com.dashboard.entity.system;

import com.dashboard.common.entity.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019-12-2
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel
@Table(name = "person")
public class Person extends BaseDO implements Serializable {

    private static final long serialVersionUID = 4248795554969207916L;

    /**
     * 用户ID
     */
    @Id
    @Column(name = "id")
    @ApiModelProperty("用户ID")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "name")
    @ApiModelProperty("用户名")
    private String name;

    /**
     * 年龄
     */
    @Column(name = "age")
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 性别: 1-男 2-女 3-保密
     */
    @Column(name = "gender")
    @ApiModelProperty("性别")
    private Integer gender;

    /**
     * 生日
     */
    @Column(name = "birthday")
    @ApiModelProperty("生日")
    private Date birthday;

    /**
     * 照片
     */
    @Column(name = "picture")
    @ApiModelProperty("照片")
    private String picture;

    /**
     * 邮箱
     */
    @Column(name = "email")
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 电话
     */
    @Column(name = "phone")
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "password")
    @ApiModelProperty("密码")
    private String password;

    /**
     * 用户状态: 0-启用 1-禁用
     */
    @Column(name = "status")
    @ApiModelProperty("用户状态: 0-启用 1-禁用")
    private Integer status;
}