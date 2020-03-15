package com.dashboard.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.UserMapper;
import com.dashboard.mapper.User;
import com.dashboard.redis.RedisClient;
import com.dashboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Queue;

/**
 * @author konglinghui
 * @description TODO
 * @date 2019/12/2 19:58
 **/
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    private Queue queue;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void createUser(User user) {
        jmsMessagingTemplate.convertAndSend(queue, "mq消息发送了1");
        jmsMessagingTemplate.convertAndSend(queue, "mq消息发送了2");
        jmsMessagingTemplate.convertAndSend(queue, "mq消息发送了3");
        jmsMessagingTemplate.convertAndSend(queue, "mq消息发送了4");
        jmsMessagingTemplate.convertAndSend(queue, "mq消息发送了5");

        // userMapper.insertUser(user);
    }
}
