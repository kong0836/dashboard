package com.dashboard.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.result.RestResult;
import com.dashboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019/11/14 19:59
 **/
@RestController
@RequestMapping("/user")
public class UserRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestController.class);

    @Reference
    private UserService userService;

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @GetMapping("create")
    // .CuratorConnectionLossException: KeeperErrorCode = ConnectionLoss
    public RestResult createUser() {

        userService.createUser(null);
        return RestResult.success();
    }
}
