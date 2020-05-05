package com.dashboard.entity.account.builder;

import com.dashboard.entity.account.AccountBudget;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author konglinghui
 * @description 消费预算构建器【建造者模式】
 * @date 2020/4/30 16:54
 **/
public class AccountBudgetBuilder implements Serializable {

    private static final long serialVersionUID = -2349668467483357754L;

    /**
     * 记录
     */
    private AccountBudget target;

    public AccountBudgetBuilder() {
        this.target = new AccountBudget();
    }

    public AccountBudgetBuilder id(Long id) {
        this.target.setId(id);
        return this;
    }

    public AccountBudgetBuilder categoryId(Long categoryId) {
        this.target.setCategoryId(categoryId);
        return this;
    }

    public AccountBudgetBuilder amount(BigDecimal amount) {
        this.target.setAmount(amount);
        return this;
    }

    public AccountBudgetBuilder status(Integer status) {
        this.target.setStatus(status);
        return this;
    }

    public AccountBudgetBuilder remark(String remark) {
        this.target.setRemark(remark);
        return this;
    }

    public AccountBudget build() {
        return this.target;
    }
}
