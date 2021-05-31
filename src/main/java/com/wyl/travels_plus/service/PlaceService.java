package com.wyl.travels_plus.service;

import com.wyl.travels_plus.entity.Place;
import com.wyl.travels_plus.entity.Province;

import java.util.List;

/**
 * @Auther:小王
 * @Date:2020/8/30
 * @Description:travels_plus
 * @version:1.0
 */
public interface PlaceService {
    List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId);

    Integer findByProvinceIdCounts(String provinceId);

    void save(Place place);

    void delete(String id);

    Place findOne(String id);

    void update(Place place);
}
