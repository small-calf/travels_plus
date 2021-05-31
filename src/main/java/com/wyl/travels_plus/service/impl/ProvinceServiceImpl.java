package com.wyl.travels_plus.service.impl;/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.dao.ProvinceDao;
import com.wyl.travels_plus.entity.Province;
import com.wyl.travels_plus.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 **/
@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {
    @Resource
    private ProvinceDao provinceDao;
    @Override
    public List<Province> findByPage(Integer page, Integer rows) {//page：当前页数
        int start = (page-1)*rows;//起始条数
        return provinceDao.findByPage(start,rows);
    }

    @Override
    public Integer findTotals() {
        return provinceDao.findTotals();
    }

    @Override
    public void save(Province province) {
//        province.setPlacecounts(0);//景点个数
        provinceDao.save(province);
    }

    @Override
    public void delete(String id) {
        provinceDao.delete(id);
    }

    @Override
    public Province findOne(String id) {
        return provinceDao.findOne(id);
    }

    @Override
    public void update(Province province) {
        provinceDao.update(province);
    }
}
