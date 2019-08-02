package com.hy.model;

import java.math.BigDecimal;

/**
 * @Author: wanghai
 * @Date:2019/6/18 22:35
 * @Copyright:reach-life
 * @Description:
 */
public class Account {

    private Long id;

    private String name;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
