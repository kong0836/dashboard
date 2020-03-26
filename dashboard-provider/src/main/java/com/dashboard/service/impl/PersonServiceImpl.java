package com.dashboard.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.common.redis.RedisClient;
import com.dashboard.mapper.PersonMapper;
import com.dashboard.mapper.other.Person;
import com.dashboard.mq.QueueConstants;
import com.dashboard.service.permission.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author konglinghui
 * @description TODO
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
    public void createUser(Person person) {
        jmsMessagingTemplate.convertAndSend(QueueConstants.TEST_QUEUE, "mq消息发送了1");
        jmsMessagingTemplate.convertAndSend(QueueConstants.TEST_QUEUE, "mq消息发送了2");
        jmsMessagingTemplate.convertAndSend(QueueConstants.TEST_QUEUE, "mq消息发送了3");
        jmsMessagingTemplate.convertAndSend(QueueConstants.TEST_QUEUE, "mq消息发送了4");
        jmsMessagingTemplate.convertAndSend(QueueConstants.TEST_QUEUE, "mq消息发送了5");

        // userMapper.insertUser(user);
    }
}
