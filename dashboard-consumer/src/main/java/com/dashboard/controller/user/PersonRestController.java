package com.dashboard.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.result.RestResult;
import com.dashboard.mapper.other.Person;
import com.dashboard.service.permission.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author konglinghui
 * @description 用户
 * @date 2019/11/14 19:59
 **/
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("/person/rest")
public class PersonRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonRestController.class);

    @Reference
    private PersonService personService;

    /**
     * 新增用户信息
     *
     * @param user
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping("/createPerson")
    public RestResult createPerson(@RequestBody Person person) {

        personService.createPerson(person);
        return RestResult.success();
    }
}
