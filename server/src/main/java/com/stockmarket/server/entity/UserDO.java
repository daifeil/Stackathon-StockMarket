package com.stockmarket.server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-8:59 PM
 */
@Getter
@Setter
@Table(name = "user")
public class UserDO {
    @Id
    private String username;
    private String password;
    private char userType;
    private String nickName;
    private String email;
    private String mobile;
}
