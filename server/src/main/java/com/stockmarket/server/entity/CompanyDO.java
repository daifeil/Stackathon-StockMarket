package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:49 PM
 */
@Getter
@Setter
public class CompanyDO {
    private String companyCode;
    private String companyName;
    private String turnover;
    private String brief;
}
