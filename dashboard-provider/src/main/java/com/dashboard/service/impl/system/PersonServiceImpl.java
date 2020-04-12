package com.dashboard.service.impl.system;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.redis.RedisClient;
import com.dashboard.mapper.system.PersonMapper;
import com.dashboard.entity.system.Person;
import com.dashboard.service.system.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import java.util.List;

/**
 * @author konglinghui
 * @description 用户管理接口
 * @date 2019/12/2 19:58
 **/
@Service
public class PersonServiceImpl implements PersonService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void createPerson(Person person) {
        personMapper.insertSelective(person);
    }

    @Override
    public void updatePerson(Person person) {
        personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public List<Person> findPersonList(Person person) {
        List<Person> personList = personMapper.select(person);

        return personList;
    }

    @Override
    public Person findPersonById(String id) {
        Person person = personMapper.selectByPrimaryKey(id);

        return person;
    }
}
