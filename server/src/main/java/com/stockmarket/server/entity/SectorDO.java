package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:41 PM
 */
@Getter
@Setter
@Entity
public class SectorDO {
    @Id
    private String sector_code;
    private String name;
    private String brief;
}
