package com.dashboard.mapper;

import com.dashboard.common.mapper.BaseMapper;
import com.dashboard.mapper.other.Person;
import org.springframework.stereotype.Repository;

/**
 * @author konglinghui
 */
@Repository
public interface PersonMapper extends BaseMapper {

    /**
     * 新增用户
     *
     * @param person
     */
    void insertUser(Person person);
}
