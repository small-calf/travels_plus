package com.wyl.travels_plus.dao;

import com.wyl.travels_plus.entity.Place;
import com.wyl.travels_plus.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther:小王
 * @Date:2020/8/30
 * @Description:travels_plus
 * @version:1.0
 */
@Mapper
public interface PlaceDao extends BaseDao<Place, String> {
    List<Place> findByProvinceIdPage(@Param("start") Integer start, @Param("rows")Integer rows, @Param("provinceId") String provinceId);

    Integer findByProvinceIdCounts(String provinceId);
}
