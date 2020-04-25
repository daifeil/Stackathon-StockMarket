package com.stockmarket.server.rest;

import com.stockmarket.server.entity.UserDO;
import com.stockmarket.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-10:17 PM
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserCtl {
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDO userDO){
        userDO.setUserType('1');
        return userService.addUser(userDO);
    }
    @GetMapping("/{username}")
    public ResponseEntity getUserInfo(@PathVariable("username") String username, OAuth2Authentication oAuth){
        return userService.getUserInfo(username,oAuth);
    }
}
