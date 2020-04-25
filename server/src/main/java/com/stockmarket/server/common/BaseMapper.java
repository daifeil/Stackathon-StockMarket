/**
 *
 */
package com.stockmarket.server.common;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author hjj
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>
{

}
