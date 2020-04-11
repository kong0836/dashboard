package com.dashboard.service.permission;

import com.dashboard.entity.other.Person;

import java.util.List;

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
     * @param person
     * @return
     */
    List<Person> findPersonList(Person person);

    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    Person findPersonById(String id);
}
