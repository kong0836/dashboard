package com.dashboard.entity.account;

import com.dashboard.common.entity.BaseTreeVO;
import lombok.Data;

import java.io.Serializable;

/**
 * @author konglinghui
 * @description 消费分类树结构
 * @date 2020/4/22 22:39
 **/
@Data
public class CategoryTreeVO extends BaseTreeVO<CategoryTreeVO> implements Serializable {

    private static final long serialVersionUID = -7048574788335324402L;

}
