package com.dashboard.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 基础实体类
 * @date 2019/9/4 19:04
 **/
@Data
@ApiModel
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -5507938964056414581L;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty("创建时间")
    private Timestamp createTime;

    /**
     * 创建人
     */
    @Column(name = "create_by")
    @ApiModelProperty("创建人")
    private String createBy;

    /**
     * 修改时间
     */
    @Column(name = "update_time", columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    @ApiModelProperty("修改时间")
    private Timestamp updateTime;

    /**
     * 修改人
     */
    @Column(name = "update_by")
    @ApiModelProperty("修改人")
    private String updateBy;
}
