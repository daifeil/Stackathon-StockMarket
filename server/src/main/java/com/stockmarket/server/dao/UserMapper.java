package com.stockmarket.server.dao;

//import com.stockmarket.server.common.BaseMapper;
//import com.stockmarket.server.entity.SimpleUserDO;
//import com.stockmarket.server.entity.UserDO;

import com.stockmarket.server.entity.UserDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Param;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-8:40 PM
 */
@Repository
public interface UserMapper extends CrudRepository<UserDO, String>, QueryByExampleExecutor<UserDO> {
    //    SimpleUserDO getUserByUsername(@Param("username") String username);
    @Modifying
    @Query(nativeQuery = true, value = "update user set confirmed='1' where username= :username")
    int setUserConfirmed(@Param("username") String username);
}
