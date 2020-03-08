-- 用户表
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    user_id     varchar(32) NOT NULL COMMENT '主键',
    role_id     varchar(32) NOT NULL COMMENT '关联角色主键',
    user_name   varchar(32) NOT NULL COMMENT '用户名',
    phone       varchar(11) NOT NULL COMMENT '手机号',
    password    varchar(32) NOT NULL COMMENT '密码',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态:0-正常 1-禁用',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (user_id),
    KEY (role_id),
    UNIQUE INDEX (user_name)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '用户表';

-- 角色表
DROP TABLE IF EXISTS role;
CREATE TABLE role (
    role_id     varchar(32) NOT NULL COMMENT '主键',
    role_name   varchar(32) NOT NULL COMMENT '角色姓名',
    order_no    int(10)     NOT NULL COMMENT '排序号',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态:0-正常 1-禁用',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (role_id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '角色表';

-- 权限表
DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
    menu_id     varchar(32)  NOT NULL COMMENT '主键',
    parent_id   varchar(32)  NOT NULL COMMENT '上级菜单主键',
    name        varchar(50)  NOT NULL COMMENT '菜单名称',
    url         varchar(255) NOT NULL COMMENT '菜单对应URL',
#   code        varchar(50)  NULL DEFAULT NULL COMMENT '授权码',
    type        int(10)      NOT NULL COMMENT '类型: 1-目录 2-菜单 3-按钮',
    icon        varchar(50)  NOT NULL COMMENT '图标',
    order_no    int(10)      NOT NULL DEFAULT 0 COMMENT '排序号',
    create_by   varchar(32)  NOT NULL COMMENT '创建人ID',
    create_time datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32)  NOT NULL COMMENT '更新人ID',
    update_time datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (menu_id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '权限表';

-- 部门表
DROP TABLE IF EXISTS department;
CREATE TABLE department (
    dept_id     varchar(32) NOT NULL COMMENT '主键',
    dept_name   varchar(10) NOT NULL COMMENT '部门名称',
    parent_id   varchar(32) NOT NULL COMMENT '上级部门主键',
    order_no    int(10)     NOT NULL COMMENT '排序号',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY (dept_id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '部门表';

DROP TABLE IF EXISTS captcha;
CREATE TABLE captcha (
    id          varchar(36) NOT NULL COMMENT '主键',
    code        varchar(6)  NOT NULL COMMENT '验证码',
    expire_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '过期时间',
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '系统验证码';

-- 字典表
DROP TABLE IF EXISTS dictionary;
CREATE TABLE dictionary (
    id          varchar(32)  NOT NULL,
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
    id          varchar(32)  NOT NULL COMMENT '主键ID',
    type        int(11)      NULL DEFAULT NULL COMMENT '日志类型',
    user_Name   varchar(50)  NOT NULL COMMENT '用户名',
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

-- user_token
DROP TABLE IF EXISTS user_token;
CREATE TABLE user_token (
    user_id     varchar(32)  NOT NULL,
    token       varchar(100) NOT NULL,
    expire_time datetime     NULL DEFAULT NULL COMMENT '过期时间',
    update_time datetime     NULL DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (user_id),
    UNIQUE INDEX token (token)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '系统用户Token';