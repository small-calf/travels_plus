package com.wyl.travels_plus.controller;/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.entity.Province;
import com.wyl.travels_plus.entity.Result;
import com.wyl.travels_plus.service.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询所有
 **/
@RestController
@RequestMapping("province")
@CrossOrigin//允许跨域
@Slf4j
public class ProvinceController {

    @Resource
    private ProvinceService provinceService;
    /**
     * 修改省份信息
     */
    @PostMapping("update")
    public Result update(@RequestBody Province province){
        Result result = new Result();
        try {
            String tags = province.getTags();
            System.out.println(tags);
            String[] t = tags.split("，");
            Province p = new Province(province.getId(),province.getName(),province.getTags(),t.length);
            provinceService.update(p);
            result.setMsg("修改省份成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 查询一个省份信息
     */
    @GetMapping("findOne")
    public Province findOne(String id){
        return provinceService.findOne(id);
    }
    /**
     * 删除省份信息
     * @return
     */
    @GetMapping("delete")
    public Result delete(String id) {
        Result result = new Result();
        try {
            provinceService.delete(id);
            result.setMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("删除省份信息失败");
        }
        return result;
    }

    /**
     * 保存省份信息
     * @param province
     * @return
     */
    @PostMapping("save")
     public Result save(@RequestBody Province province) {
         Result result = new Result();
         try {
             String tags = province.getTags();
             String[] t = tags.split("，");
             Province p = new Province(province.getId(),province.getName(),province.getTags(),t.length);
             provinceService.save(p);
             result.setMsg("保存成功");
         } catch (Exception e) {
             e.printStackTrace();
             result.setState(false).setMsg("保存省份信息失败");
         }
         return result;
     }
    /**
     * 查询所有
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("findByPage")
    public Map<String, Object> findByPage(Integer page, Integer rows) {
        page = page==null?1 : page;
        rows = rows==null?4 : rows;

        Map<String, Object> map = new HashMap<>();
        //分页处理
        List<Province> provinces = provinceService.findByPage(page, rows);
        //计算总页数
        Integer totals = provinceService.findTotals();
        Integer totalPage = totals % rows == 0?totals/rows : (totals / rows)+1;//多少页
        map.put("provinces",provinces);
        map.put("totals",totals);//总条数
        log.info("总条数"+totals);
        map.put("totalPage",totalPage);//多少页
        log.info("多少页"+totalPage);
        map.put("page",page);//当前页
        return map;
    }
}
