package com.stockmarket.server.service;

import com.stockmarket.server.entity.UserDO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:13 PM
 */
public interface UserService {
    /**
     * user account confirm
     * @param username
     * @return
     */
    ResponseEntity userConfirm(String username);

    /**
     * add new user -- register
     * @param userDO
     * @return
     */
    ResponseEntity addUser(UserDO userDO);
    /**
     * get user info by username
     * @param username
     * @return
     */
    ResponseEntity<UserDO> getUserInfo(String username, OAuth2Authentication oAuth);
}
