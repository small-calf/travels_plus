package com.wyl.travels_plus.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */
public interface BaseDao<T, K> {
    void save(T t);

    void update(T t);

    void delete(K k);

    T findOne(K k);

    List<T> findAll();

    List<T> findByPage(@Param("start") Integer start, @Param("rows") Integer rows);

    Integer findTotals();
}
