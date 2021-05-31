package com.wyl.travels_plus.dao;/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 **/
@Mapper
public interface ProvinceDao extends BaseDao<Province, String> {

}
