package com.dashboard.service.permission;

import com.dashboard.common.entity.Page;
import com.dashboard.entity.system.Person;
import com.dashboard.entity.system.PersonPageInfo;

/**
 * @author konglinghui
 * @description 用户信息接口
 * @date 2019/12/2 19:58
 **/
public interface PersonService {

    /**
     * 新增用户信息
     *
     * @param person
     */
    void createPerson(Person person);

    /**
     * 更新用户信息
     *
     * @param person
     */
    void updatePerson(Person person);

    /**
     * 查询用户信息
     *
     * @param personPageInfo
     * @return
     */
    Page<Person> findPersonList(PersonPageInfo personPageInfo);

    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    Person findPersonById(String id);
}
