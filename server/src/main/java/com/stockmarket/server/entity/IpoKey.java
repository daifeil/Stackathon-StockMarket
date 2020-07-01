package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/6/8-10:50 AM
 */
@Getter
@Setter
@Embeddable
public class IpoKey implements Serializable {
    private String companyCode;
    private String exchangeCode;
}
