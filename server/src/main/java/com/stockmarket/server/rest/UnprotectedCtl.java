package com.stockmarket.server.rest;

import com.stockmarket.server.entity.UserDO;
import com.stockmarket.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-11:43 PM
 */
@RestController
@RequestMapping("/api/v1/unprotected")
public class UnprotectedCtl {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDO userDO){
        userDO.setUserType('1');
        return userService.addUser(userDO);
    }
}
