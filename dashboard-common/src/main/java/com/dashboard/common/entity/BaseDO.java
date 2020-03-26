package com.dashboard.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 基础实体类
 * @date 2019/9/4 19:04
 **/
@Data
public class BaseDO implements Serializable {

    private static final long serialVersionUID = -5507938964056414581L;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Timestamp updateTime;

    /**
     * 修改人
     */
    private String updateBy;
}
