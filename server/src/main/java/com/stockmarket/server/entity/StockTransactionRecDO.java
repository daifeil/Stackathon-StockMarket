package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:38 PM
 */
@Getter
@Setter
@Entity
public class StockTransactionRecDO {
    @Id
    private long Id;
    private String companyCode;
    private String exchangeCode;
    private float price;
    private String transactionCate;
    private String transactionTime;
}
