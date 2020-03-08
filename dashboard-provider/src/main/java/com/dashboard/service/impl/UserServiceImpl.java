package com.dashboard.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.dashboard.mapper.UserMapper;
import com.dashboard.mapper.User;
import com.dashboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Override
    public void createUser(User user) {

        LOGGER.info("调用了调用了");
        // userMapper.insertUser(user);
    }
}
