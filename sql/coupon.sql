-- 优惠券基本信息表
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
    id          bigint(20)  NOT NULL COMMENT '主键',
    coupon_name varchar(16) NOT NULL COMMENT '优惠券名称',
    type        tinyint(2)  NOT NULL COMMENT '优惠券类型',
    status      tinyint(2)  NOT NULL DEFAULT 0 COMMENT '状态: 0-启用 1-禁用',
    remark      varchar(32) NULL     DEFAULT '' COMMENT '备注',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_id` (id)
)
    ENGINE = InnoDB
    CHARACTER SET = utf8
    COMMENT = '优惠券基本信息表';

-- ---------------------------------------------------------------------------------------------------------------------
-- 优惠券使用范围表

-- ---------------------------------------------------------------------------------------------------------------------
-- 优惠券审核记录表
DROP TABLE IF EXISTS `coupon_receive_record`;
CREATE TABLE `coupon_receive_record` (
    id          bigint(20)  NOT NULL COMMENT '主键',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_verify_record_id` (id)
)
    ENGINE InnoDB
    CHARACTER SET = utf8
    COMMENT = '优惠券审核记录表';
-- ---------------------------------------------------------------------------------------------------------------------
-- 优惠券领取记录表
DROP TABLE IF EXISTS `coupon_receive_record`;
CREATE TABLE `coupon_receive_record` (
    id          bigint(20)  NOT NULL COMMENT '主键',
    create_by   varchar(32) NOT NULL COMMENT '创建人ID',
    create_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_by   varchar(32) NOT NULL COMMENT '更新人ID',
    update_time datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
    PRIMARY KEY `coupon_receive_record_id` (id)
)
    ENGINE InnoDB
    CHARACTER SET = utf8
    COMMENT = '优惠券领取记录表';
-- ---------------------------------------------------------------------------------------------------------------------
-- 优惠券消费记录表
-- ---------------------------------------------------------------------------------------------------------------------