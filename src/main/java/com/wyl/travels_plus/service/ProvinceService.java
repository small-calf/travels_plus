package com.wyl.travels_plus.service;

import com.wyl.travels_plus.entity.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */

public interface ProvinceService {

    //参数1：当前页   参数2：每页显示记录数
    List<Province> findByPage(Integer page,Integer rows);

    //查询总条数
    Integer findTotals();

    //保存省份的方法
    void save(Province province);

    //删除省份
    void delete(String id);

    //查询省份信息
    Province findOne(String id);

    //修改省份信息
    void update(Province province);
}
