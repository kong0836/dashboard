package com.dashboard.controller.system;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dashboard.common.entity.Page;
import com.dashboard.common.enums.BaseResultEnum;
import com.dashboard.common.result.RestResult;
import com.dashboard.date.DateTimeUtils;
import com.dashboard.entity.system.Person;
import com.dashboard.entity.system.PersonPageInfo;
import com.dashboard.service.system.PersonService;
import com.dashboard.snowflake.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @author konglinghui
 * @description 用户管理接口
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
     * @param person
     * @return
     */
    @ApiOperation("新增用户信息")
    @PostMapping("/createPerson")
    public RestResult createPerson(@RequestBody Person person) {

        person.setId(SnowflakeIdWorker.generateId());
        person.setCreateTime(DateTimeUtils.currentTimeStamp());
        person.setCreateBy("0");
        person.setUpdateBy("0");
        person.setPassword("123456");

        personService.createPerson(person);

        return RestResult.success();
    }

    /**
     * 更新用户信息
     *
     * @param person
     * @return
     */
    @ApiOperation("更新用户信息")
    @PostMapping("/updatePerson")
    public RestResult updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);

        return RestResult.success();
    }

    /**
     * 查询用户信息
     *
     * @param personPageInfo
     * @return
     */
    @ApiOperation("查询用户信息")
    @PostMapping("/findPersonList")
    public RestResult findPersonList(@RequestBody PersonPageInfo personPageInfo) {
        if (Objects.isNull(personPageInfo)) {
            personPageInfo = new PersonPageInfo();
        }
        if (StringUtils.isBlank(personPageInfo.getName())) {
            personPageInfo.setName(null);
        }

        Page<Person> page = personService.findPersonList(personPageInfo);

        return RestResult.success(page);
    }

    /**
     * 查询用户信息
     *
     * @param id
     * @return
     */
    @ApiOperation("查询用户信息")
    @GetMapping("/findPersonById/{id}")
    public RestResult findPersonById(@PathVariable String id) {
        if (StringUtils.isBlank(id)) {
            return RestResult.fail(BaseResultEnum.PARAM_ERROR);
        }

        Person person = personService.findPersonById(id);

        return RestResult.success(person);
    }
}
