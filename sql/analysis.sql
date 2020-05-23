-- 消费记录汇总表
DROP TABLE IF EXISTS analysis_account_total;

CREATE TABLE analysis_account_total (
    id            bigint(20)     NOT NULL COMMENT '主键',
    person_id     bigint(20)     NOT NULL COMMENT '用户主键',
    consumer_date date           NOT NULL COMMENT '消费日期：默认当天',
    type          tinyint(2)     NOT NULL COMMENT '消费类型: 1-收入 2-支出',
    amount        decimal(10, 2) NOT NULL COMMENT '金额: 单位(元)',
    status        tinyint(2)     NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    remark        varchar(32)    NULL     DEFAULT '' COMMENT '备注',
    create_by     varchar(32)    NOT NULL COMMENT '创建人ID',
    create_time   datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by     varchar(32)    NOT NULL COMMENT '更新人ID',
    update_time   datetime       NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `account_total_id` (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '消费记录汇总表';