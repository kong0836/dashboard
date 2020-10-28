package com.dashboard.service.impl.permission;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.entity.Page;
import com.dashboard.entity.system.Person;
import com.dashboard.entity.system.PersonPageInfo;
import com.dashboard.mapper.permission.PersonMapper;
import com.dashboard.service.cache.RedisService;
import com.dashboard.service.permission.PersonService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private RedisService redisService;

    @Override
    public void createPerson(Person person) {
        personMapper.insertSelective(person);
    }

    @Override
    public void updatePerson(Person person) {
        personMapper.updateByPrimaryKeySelective(person);
    }

    @Override
    public Page<Person> findPersonList(PersonPageInfo personPageInfo) {
        // 分页
        PageHelper.startPage(personPageInfo);

        Person person = new Person();
        BeanUtils.copyProperties(personPageInfo, person);

        List<Person> personList = personMapper.select(person);
        PageInfo<Person> pageInfo = new PageInfo(personList);
        Page<Person> page = new Page<>();
        BeanUtils.copyProperties(pageInfo, page);

        return page;
    }

    @Override
    public Person findPersonById(String id) {

        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Person> findPersonListAll() {

        redisService.set("name1", "张三");
        redisService.set("age1", "25");
        redisService.set("sex1", "man");
        redisService.set("member1", "222");

        String o = redisService.get("name1");
        System.out.println(o);
        System.out.println(redisService.get("age1").toString());
        System.out.println(redisService.get("sex1").toString());
        System.out.println(redisService.get("member1").toString());

        return personMapper.selectAll();
    }
}
