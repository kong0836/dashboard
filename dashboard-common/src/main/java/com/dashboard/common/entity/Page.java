package com.dashboard.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author konglinghui
 * @description 分页数据实体
 * @date 2020/4/13 11:08
 **/
@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1415371368399656821L;

    /**
     * 当前页
     */
    private int pageNum;

    /**
     * 每页的数量
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 结果集
     */
    private List<T> list;
}
