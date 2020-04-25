package com.stockmarket.server.serviceImp;

import com.stockmarket.server.dao.UserMapper;
import com.stockmarket.server.entity.UserDO;
import com.stockmarket.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;


/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-9:15 PM
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity userConfirm(String username) {
        userMapper.setUserConfirmed(username);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity addUser(UserDO userDO) {

        userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
        if(userMapper.existsWithPrimaryKey(userDO.getUsername())){ // user already exists
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        userMapper.insert(userDO);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<UserDO> getUserInfo(String username, OAuth2Authentication oAuth) {
        if(!oAuth.getAuthorities().contains("0") && !username.equals(oAuth.getName())){
            // return forbidden when you are not admin and trying to get other person's info
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(userMapper.selectByPrimaryKey(username));
    }
}
