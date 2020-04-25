package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-8:42 PM
 */
@Getter
@Setter
public class SimpleUserDO {
    private String username;
    private String password;
    private char userType;
}
