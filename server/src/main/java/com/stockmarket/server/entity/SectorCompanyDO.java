package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:49 PM
 */
@Getter
@Setter
@Entity

public class SectorCompanyDO {
    @EmbeddedId
    private SectorCompanyKey id;
//    private String sectorCode;
//    private String sectorName;
    private String companyCode;
    private String companyName;


}
