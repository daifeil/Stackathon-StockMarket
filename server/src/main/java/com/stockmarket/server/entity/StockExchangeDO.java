package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:51 PM
 */
@Getter
@Setter
public class StockExchangeDO {
    private String exchange_code;
    private String brief;
    private String address;
    private String remark;
}
