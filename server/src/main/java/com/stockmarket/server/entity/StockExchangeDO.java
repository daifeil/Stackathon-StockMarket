package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:51 PM
 */
@Getter
@Setter
@Entity
public class StockExchangeDO {
    @Id
    private String exchange_code;
    private String brief;
    private String address;
    private String remark;
}
