package com.wyl.travels_plus.service.impl;/**
 * @Auther:小王
 * @Date:2020/8/30
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.dao.PlaceDao;
import com.wyl.travels_plus.entity.Place;
import com.wyl.travels_plus.entity.Province;
import com.wyl.travels_plus.service.PlaceService;
import com.wyl.travels_plus.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 **/
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
    @Resource
    private PlaceDao placeDao;
    @Resource
    private ProvinceService provinceService;
    @Override
    public List<Place> findByProvinceIdPage(Integer page, Integer rows, String provinceId) {
        int start = (page-1)*rows;
        return placeDao.findByProvinceIdPage(start,rows,provinceId);
    }

    @Override
    public Integer findByProvinceIdCounts(String provinceId) {
        return placeDao.findByProvinceIdCounts(provinceId);
    }

    @Override
    public void save(Place place) {
        //保存景点
        placeDao.save(place);
        //查询原始省份信息
        Province province = provinceService.findOne(place.getProvinceid());
        //更新省份信息的景点个数
        province.setPlacecounts(province.getPlacecounts()+1);
        provinceService.update(province);
    }

    @Override
    public void delete(String id) {
        //更新省份景点个数，删除景点
        Place place = placeDao.findOne(id);
        Province province = provinceService.findOne(place.getProvinceid());
        province.setPlacecounts(province.getPlacecounts()-1);
        provinceService.update(province);
        placeDao.delete(id);
    }

    @Override
    public Place findOne(String id) {
        return placeDao.findOne(id);
    }

    @Override
    public void update(Place place) {
        placeDao.update(place);
    }
}
