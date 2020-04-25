package com.stockmarket.server.configure.security;

import com.stockmarket.server.dao.UserMapper;
import com.stockmarket.server.entity.SimpleUserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/2/10-6:22 PM
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        SimpleUserDO user=userMapper.getUserByUsername(username);
        if(user==null){
            throw new UsernameNotFoundException("user not found with username: "+username+" !");
        }
        return new User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType()+""));
    }
}