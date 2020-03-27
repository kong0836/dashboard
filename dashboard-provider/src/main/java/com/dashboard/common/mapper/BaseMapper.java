package com.dashboard.common.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author konglinghui
 * @description TODO
 * @date 2020/3/26 15:47
 **/
public interface BaseMapper<T> extends tk.mybatis.mapper.common.BaseMapper<T>,
        MySqlMapper<T>,
        IdsMapper<T>,
        ConditionMapper<T>,
        ExampleMapper<T> {
}
