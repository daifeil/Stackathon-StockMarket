package com.stockmarket.server.configure.security;

import com.stockmarket.server.dao.UserMapper;
import com.stockmarket.server.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/2/10-6:22 PM
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {

       UserDO user=userMapper.findById(username).get();
        if(user==null){
            throw new UsernameNotFoundException("user not found with username: "+username+" !");
        }

        return new User(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getUserType()+""));
    }
}