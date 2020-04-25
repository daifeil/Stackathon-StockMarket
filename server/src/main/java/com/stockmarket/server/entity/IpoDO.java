package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:43 PM
 */
@Getter
@Setter
public class IpoDO {
    private String companyCode;
    private String exchangeCode;
    private float price;
    private long totalShare;
    private String openTime;
    private String remark;
}
