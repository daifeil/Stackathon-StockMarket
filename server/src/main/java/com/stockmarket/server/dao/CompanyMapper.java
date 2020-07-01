package com.stockmarket.server.dao;

import com.stockmarket.server.entity.CompanyDO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 * @author daifeil@cn.ibm.com
 * @description
 * @date 2020/4/25-8:40 PM
 */
public interface CompanyMapper extends CrudRepository<CompanyDO, String>, QueryByExampleExecutor<CompanyDO> {

}
