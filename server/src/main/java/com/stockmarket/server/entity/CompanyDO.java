package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:49 PM
 */
@Getter
@Setter
@Entity
public class CompanyDO {
    @Id
    private String companyCode;
    private String companyName;
    private String turnover;
    private String brief;
}
