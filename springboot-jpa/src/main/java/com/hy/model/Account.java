package com.hy.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @Author: wanghai
 * @Date:2019/6/4 21:37
 * @Copyright:reach-life
 * @Description:
 */
@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(10) comment '主键'")
    private Integer id;

    @Column(columnDefinition = "varchar(100) default '' comment '名字'")
    private String name;

    @Column(columnDefinition = "decimal(10,2) default '0.00' comment '余额'")
    private BigDecimal amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
