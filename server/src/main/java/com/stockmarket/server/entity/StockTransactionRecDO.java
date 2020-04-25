package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:38 PM
 */
@Getter
@Setter
public class StockTransactionRecDO {
    private String companyCode;
    private String exchangeCode;
    private float price;
    private String transactionCate;
    private String transactionTime;
}
