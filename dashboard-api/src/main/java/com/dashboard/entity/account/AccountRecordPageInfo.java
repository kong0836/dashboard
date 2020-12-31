package com.dashboard.entity.account;

import com.dashboard.common.entity.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费记录分页实体
 * @date 2020/5/4 6:45
 **/
@Data
@ApiModel
@EqualsAndHashCode(callSuper = false)
public class AccountRecordPageInfo extends Page<AccountRecord> implements Serializable {

    private static final long serialVersionUID = -6838807047606800793L;

    /**
     * 用户名
     */
    @Column(name = "name")
    @ApiModelProperty("用户名")
    private String name;
}
