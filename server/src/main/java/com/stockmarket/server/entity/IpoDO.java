package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:43 PM
 */
@Getter
@Setter
@Entity
public class IpoDO {
    @EmbeddedId
    private IpoKey id;
//    private String companyCode;
//    private String exchangeCode;
    private float price;
    private long totalShare;
    private String openTime;
    private String remark;
}
