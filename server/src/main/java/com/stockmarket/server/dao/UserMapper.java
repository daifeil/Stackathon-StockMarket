package com.stockmarket.server.dao;

import com.stockmarket.server.common.BaseMapper;
import com.stockmarket.server.entity.SimpleUserDO;
import com.stockmarket.server.entity.UserDO;
import org.apache.ibatis.annotations.Param;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-8:40 PM
 */
public interface UserMapper extends BaseMapper<UserDO> {
    SimpleUserDO getUserByUsername(@Param("username") String username);
    int setUserConfirmed(@Param("username") String username);
}
