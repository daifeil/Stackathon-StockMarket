package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/6/8-10:47 AM
 */
@Embeddable
@Getter
@Setter
public class SectorCompanyKey implements Serializable {
    private String sectorCode;
    private String sectorName;
}