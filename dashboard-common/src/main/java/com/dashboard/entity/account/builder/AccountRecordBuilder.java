package com.dashboard.entity.account.builder;

import com.dashboard.entity.account.AccountRecord;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author konglinghui
 * @description 记录构建器【建造者模式】
 * @date 2020/4/30 16:54
 **/
public class AccountRecordBuilder implements Serializable {

    private static final long serialVersionUID = -2349668467483357754L;

    /**
     * 记录
     */
    private AccountRecord target;

    public AccountRecordBuilder() {
        this.target = new AccountRecord();
    }

    public AccountRecordBuilder id(Long id) {
        this.target.setId(id);
        return this;
    }

    public AccountRecordBuilder personId(Long personId) {
        this.target.setPersonId(personId);
        return this;
    }

    public AccountRecordBuilder categoryId(Long categoryId) {
        this.target.setCategoryId(categoryId);
        return this;
    }

    public AccountRecordBuilder amount(BigDecimal amount) {
        this.target.setAmount(amount);
        return this;
    }

    public AccountRecordBuilder status(Integer status) {
        this.target.setStatus(status);
        return this;
    }

    public AccountRecordBuilder remark(String remark) {
        this.target.setRemark(remark);
        return this;
    }

    public AccountRecordBuilder createTime(Timestamp createTime) {
        this.target.setCreateTime(createTime);
        return this;
    }

    public AccountRecordBuilder createBy(String createBy) {
        this.target.setCreateBy(createBy);
        return this;
    }

    public AccountRecordBuilder updateBy(String updateBy) {
        this.target.setUpdateBy(updateBy);
        return this;
    }

    public AccountRecordBuilder updateTime(Timestamp updateTime) {
        this.target.setUpdateTime(updateTime);
        return this;
    }

    public AccountRecord build() {
        return this.target;
    }
}
