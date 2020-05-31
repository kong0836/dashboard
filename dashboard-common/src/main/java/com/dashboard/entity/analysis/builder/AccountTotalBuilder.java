package com.dashboard.entity.analysis.builder;

import com.dashboard.entity.analysis.AccountTotal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 消费记录汇总【建造者模式】
 * @date 2020/5/22 20:56
 **/
public class AccountTotalBuilder implements Serializable {

    private static final long serialVersionUID = 1376031325620284409L;

    /**
     * 消费记录汇总
     */
    private AccountTotal target;

    public AccountTotalBuilder() {
        this.target = new AccountTotal();
    }

    public AccountTotalBuilder id(Long id) {
        this.target.setId(id);
        return this;
    }

    public AccountTotalBuilder personId(Long personId) {
        this.target.setPersonId(personId);
        return this;
    }

    public AccountTotalBuilder consumerDate(Timestamp consumerDate) {
        this.target.setConsumerDate(consumerDate);
        return this;
    }

    public AccountTotalBuilder type(Integer type) {
        this.target.setType(type);
        return this;
    }

    public AccountTotalBuilder amount(BigDecimal amount) {
        this.target.setAmount(amount);
        return this;
    }

    public AccountTotalBuilder status(Integer status) {
        this.target.setStatus(status);
        return this;
    }

    public AccountTotalBuilder remark(String remark) {
        this.target.setRemark(remark);
        return this;
    }

    public AccountTotalBuilder createTime(Timestamp createTime) {
        this.target.setCreateTime(createTime);
        return this;
    }

    public AccountTotalBuilder createBy(String createBy) {
        this.target.setCreateBy(createBy);
        return this;
    }

    public AccountTotalBuilder updateBy(String updateBy) {
        this.target.setUpdateBy(updateBy);
        return this;
    }

    public AccountTotalBuilder updateTime(Timestamp updateTime) {
        this.target.setUpdateTime(updateTime);
        return this;
    }

    public AccountTotal build() {
        return this.target;
    }
}
