-- 账单分类表
DROP TABLE IF EXISTS account_category;
CREATE TABLE account_category (
    id          bigint(20)  NOT NULL COMMENT '主键',
    parent_id   bigint(20)  NOT NULL COMMENT '上级分类主键',
    name        varchar(32) NOT NULL COMMENT '分类名称',
    type        tinyint(2)  NOT NULL COMMENT '消费类型: 1-收入 2-支出',
    icon        varchar(32) NOT NULL COMMENT '图标',
    order_no    int(10)     NOT NULL DEFAULT 0 COMMENT '排序号',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    remark      varchar(32) NULL     DEFAULT '' COMMENT '备注',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `account_category_id` (id),
    KEY `account_category_parent_id` (parent_id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '消费分类表';

-- 账单记录表
DROP TABLE IF EXISTS account_record;
CREATE TABLE account_record (
    id          bigint(20)     NOT NULL COMMENT '主键',
    person_id   bigint(20)     NOT NULL COMMENT '用户主键',
    category_id bigint(20)     NOT NULL COMMENT '账单分类主键',
    type        tinyint(2)     NOT NULL COMMENT '收支类型: 1-收入，2-支出',
    amount      decimal(10, 2) NOT NULL COMMENT '金额: 单位(分)',
    remark      varchar(32)    NULL     DEFAULT '' COMMENT '备注',
    create_by   varchar(32)    NOT NULL COMMENT '创建人ID',
    create_time datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32)    NOT NULL COMMENT '更新人ID',
    update_time datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `account_category_record_id` (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '消费记录表';