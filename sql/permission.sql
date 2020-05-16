-- 用户表
DROP TABLE IF EXISTS person;
CREATE TABLE person (
    id          bigint(20)   NOT NULL COMMENT '主键',
    name        varchar(32)  NOT NULL COMMENT '用户名',
    age         smallint(6)  NULL     DEFAULT NULL COMMENT '年龄',
    gender      tinyint(2)   NOT NULL DEFAULT 1 COMMENT '性别: 1-男 2-女 3-保密',
    birthday    datetime     NULL     DEFAULT NULL COMMENT '生日',
    picture     varchar(256) NULL     DEFAULT '' COMMENT '照片',
    email       varchar(256) NULL     DEFAULT '' COMMENT '邮箱',
    phone       varchar(16)  NULL     DEFAULT '' COMMENT '手机号',
    password    varchar(256) NULL     DEFAULT '123456' COMMENT '密码: 默认值-123456',
    status      tinyint(2)   NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    create_by   varchar(32)  NOT NULL DEFAULT '0' COMMENT '创建人ID',
    create_time datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32)  NOT NULL DEFAULT '0' COMMENT '更新人ID',
    update_time datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `person_id` (id),
    UNIQUE INDEX (name)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '用户表';

-- 权限-角色表
DROP TABLE IF EXISTS permission_role;
CREATE TABLE permission_role (
    id          bigint(20)  NOT NULL COMMENT '主键',
    name        varchar(32) NOT NULL COMMENT '角色名称',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    description varchar(32) NULL     DEFAULT '' COMMENT '描述',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `permission_role_id` (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '角色表';

-- 权限-资源表
DROP TABLE IF EXISTS permission_resource;
CREATE TABLE permission_resource (
    id          bigint(20)  NOT NULL COMMENT '主键',
    parent_id   bigint(20)  NOT NULL COMMENT '上级资源主键',
    name        varchar(32) NOT NULL COMMENT '资源名称',
    url         varchar(64) NOT NULL DEFAULT '' COMMENT '资源URL',
    code        varchar(50) NOT NULL DEFAULT '' COMMENT '授权码',
    type        tinyint(2)  NOT NULL COMMENT '类型: 1-目录 2-菜单 3-按钮',
    icon        varchar(32) NOT NULL COMMENT '图标',
    order_no    int(10)     NOT NULL DEFAULT 0 COMMENT '排序号',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    description varchar(32) NULL     DEFAULT '' COMMENT '描述',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `permission_resource_id` (id),
    KEY `permission_resource_parent_id` (parent_id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '权限表';

-- 权限-组织表
DROP TABLE IF EXISTS permission_organization;
CREATE TABLE permission_organization (
    id          bigint(20)  NOT NULL COMMENT '主键',
    parent_id   varchar(32) NOT NULL COMMENT '上级组织主键',
    name        varchar(10) NOT NULL COMMENT '组织名称',
    order_no    int(10)     NOT NULL COMMENT '排序号',
    description varchar(32) NULL     DEFAULT '' COMMENT '描述',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `permission_organization` (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '部门表';

DROP TABLE IF EXISTS captcha;
CREATE TABLE captcha (
    id          bigint(20) NOT NULL COMMENT '主键',
    code        varchar(6) NOT NULL COMMENT '验证码',
    expire_time datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '系统验证码';

-- 字典表
DROP TABLE IF EXISTS dictionary;
CREATE TABLE dictionary (
    id          bigint(20)   NOT NULL,
    code        varchar(10)  NULL DEFAULT NULL COMMENT 'key',
    name        varchar(20)  NULL DEFAULT NULL COMMENT 'value',
    type        varchar(10)  NULL DEFAULT NULL,
    order_no    int(10)      NULL DEFAULT NULL,
    creator_id  varchar(32)  NULL DEFAULT NULL,
    create_time datetime     NULL DEFAULT NULL,
    updator_id  varchar(32)  NULL DEFAULT NULL,
    update_time datetime     NULL DEFAULT NULL,
    status      tinyint(1)   NULL DEFAULT 0,
    remark      varchar(255) NULL DEFAULT NULL COMMENT '备注',
    is_leaf     tinyint(4)   NULL DEFAULT 0 COMMENT '是否叶子节点',
    PRIMARY KEY (id),
    UNIQUE INDEX code (code)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '字典表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log (
    id          bigint(20)   NOT NULL COMMENT '主键ID',
    type        int(11)      NULL DEFAULT NULL COMMENT '日志类型',
    person_Name varchar(50)  NOT NULL COMMENT '用户名',
    operation   varchar(50)  NOT NULL COMMENT '用户操作',
    uri         varchar(100) NULL DEFAULT NULL COMMENT '请求URI',
    method      varchar(200) NULL DEFAULT NULL COMMENT '请求方法',
    params      varchar(500) NULL DEFAULT NULL COMMENT '请求参数',
    time        bigint(20)   NOT NULL COMMENT '请求时长',
    ip          varchar(20)  NULL DEFAULT NULL COMMENT 'IP地址',
    create_time datetime     NOT NULL COMMENT '操作时间',
    status      tinyint(1)   NULL DEFAULT 1 COMMENT '状态',
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '系统日志表';

-- person_token
DROP TABLE IF EXISTS person_token;
CREATE TABLE person_token (
    person_id   bigint(20)   NOT NULL,
    token       varchar(100) NOT NULL,
    expire_time datetime     NULL DEFAULT NULL COMMENT '过期时间',
    update_time datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (person_id),
    UNIQUE INDEX token (token)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '系统用户Token';