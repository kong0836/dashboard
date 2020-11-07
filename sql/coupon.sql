-- 卡券基本信息表
DROP TABLE IF EXISTS `coupon_info`;
CREATE TABLE `coupon_info` (
    `id`           bigint(20)   NOT NULL COMMENT '主键',
    `coupon_img`   varchar(16)  NOT NULL COMMENT '卡券名称',
    `coupon_name`  varchar(16)  NOT NULL COMMENT '卡券名称',
    `coupon_type`  tinyint(2)   NOT NULL COMMENT '卡券类型',
    `status`       tinyint(2)   NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    `denomination` int(11)      NOT NULL COMMENT '卡券面值',
    `price`        int(11)      NOT NULL COMMENT '卡券售价',
    `quantity`     int(11)      NOT NULL COMMENT '库存',
    `description`  varchar(500) NULL COMMENT '使用须知',
    `remark`       varchar(32)  NULL     DEFAULT '' COMMENT '备注',
    `create_by`    varchar(32)  NOT NULL COMMENT '创建人ID',
    `create_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`    varchar(32)  NOT NULL COMMENT '更新人ID',
    `update_time`  datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_id` (`id`)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '卡券基本信息表';

-- ---------------------------------------------------------------------------------------------------------------------
-- 卡券使用范围表
CREATE TABLE `coupon_rule` (
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `coupon_id`   bigint(20)  NOT NULL COMMENT '卡券基本信息表主键',
    `remark`      varchar(32) NULL     DEFAULT '' COMMENT '备注',
    `create_by`   varchar(32) NOT NULL COMMENT '创建人ID',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(32) NOT NULL COMMENT '更新人ID',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_rule_id` (`id`)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '卡券规则';
-- ---------------------------------------------------------------------------------------------------------------------
-- 卡券审核记录表
DROP TABLE IF EXISTS `coupon_verify_record`;
CREATE TABLE `coupon_verify_record` (
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `create_by`   varchar(32) NOT NULL COMMENT '创建人ID',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(32) NOT NULL COMMENT '更新人ID',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_verify_record_id` (`id`)
)
    ENGINE InnoDB
    CHARACTER SET = utf8
    COMMENT = '卡券审核记录表';
-- ---------------------------------------------------------------------------------------------------------------------
-- 卡券领取记录表
DROP TABLE IF EXISTS `coupon_receive_record`;
CREATE TABLE `coupon_receive_record` (
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `create_by`   varchar(32) NOT NULL COMMENT '创建人ID',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(32) NOT NULL COMMENT '更新人ID',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_receive_record_id` (`id`)
)
    ENGINE InnoDB
    CHARACTER SET = utf8
    COMMENT = '卡券领取记录表';
-- ---------------------------------------------------------------------------------------------------------------------
-- 卡券消费记录表
DROP TABLE IF EXISTS `coupon_receive_record`;
CREATE TABLE `coupon_receive_record` (
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `create_by`   varchar(32) NOT NULL COMMENT '创建人ID',
    `create_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(32) NOT NULL COMMENT '更新人ID',
    `update_time` datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_receive_record_id` (`id`)
)
    ENGINE InnoDB
    CHARACTER SET = utf8
    COMMENT = '卡券消费记录表';
-- ---------------------------------------------------------------------------------------------------------------------