package com.hy.model;

import org.beetl.sql.core.annotatoin.Table;

import java.math.BigDecimal;

/**
 * @Author: wanghai
 * @Date:2019/6/5 22:30
 * @Copyright:reach-life
 * @Description:
 */
@Table(name = "tb_account")
public class Account {

    private int id ;

    private String name ;

    private BigDecimal amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
