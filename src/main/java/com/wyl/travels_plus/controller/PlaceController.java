package com.wyl.travels_plus.controller;/**
 * @Auther:小王
 * @Date:2020/8/30
 * @Description:travels_plus
 * @version:1.0
 */

import com.wyl.travels_plus.entity.Place;
import com.wyl.travels_plus.entity.Result;
import com.wyl.travels_plus.service.PlaceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 **/
@RestController
@RequestMapping("place")
@CrossOrigin
@Slf4j
public class PlaceController {

    @Resource
    private PlaceService placeService;

    @Value("${upload.dir}")
    private String realpath;
    /**
     * 修改景点信息
     */
    @PostMapping("update")
    public Result update(MultipartFile file, Place place){
        Result result = new Result();

        try {
            //对接收文件做base64
            if (file != null){
                String filepath = Base64Utils.encodeToString(file.getBytes());
                place.setPicpath(filepath);
                String newFileName = UUID.randomUUID().toString()+file.getOriginalFilename();
                file.transferTo(new File(realpath,newFileName));
            }
            //修改景点信息
            placeService.update(place);
            result.setMsg("修改景点信息成功");
        } catch (IOException e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }
        return result;
    }
    /**
     * 查询景点
     */
    @GetMapping("findOne")
    public Place findOne(String id){
        return placeService.findOne(id);
    }
    /**
     * 删除景点
     * @param id
     * @return
     */
    @GetMapping("delete")
    public Result delete(String id){
        Result result = new Result();
        try {
            placeService.delete(id);
            result.setMsg("删除景点信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(false).setMsg("删除景点信息失败");
        }
        return result;
    }
    /**
     * 保存景点信息
     * @param file
     * @return
     */
    @PostMapping("save")
    public Result save(MultipartFile file, Place place){
        Result result = new Result();
        System.out.println(file.getOriginalFilename());//获取文件名称
        System.out.println(place);
        //文件上传

        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());//获取文件名后缀
            System.out.println("。。。"+extension );
            String newFileName = UUID.randomUUID().toString()+file.getOriginalFilename();
            System.out.println("。。。"+newFileName);
            place.setPicpath(Base64Utils.encodeToString(file.getBytes()));
            System.out.println("。。。"+newFileName);
            //System.out.println("22   "+Base64Utils.encodeToString(newFileName.getBytes()));
            System.out.println("1111  "+realpath);
            file.transferTo(new File(realpath,newFileName));

            //保存place对象
            placeService.save(place);
            result.setMsg("保存景点信息成功");
        } catch (IOException e) {
            e.printStackTrace();
            result.setState(false).setMsg(e.getMessage());
        }


        return result;
    }
    /**
     * 根据省份id查询景点的方法
     */
    @GetMapping("findAllPlace")
    public Map<String,Object> findAllPlace(Integer page,Integer rows, String provinceId){
        page = page==null?1 : page;
        rows = rows==null?1 : rows;

        Map<String, Object> map = new HashMap<>();
        //景点集合
        List<Place> places = placeService.findByProvinceIdPage(page, rows, provinceId);
        System.out.println(places+"1111");
        //处理分页
        Integer counts = placeService.findByProvinceIdCounts(provinceId);
        //总页数
        Integer totalPage = counts%rows==0?counts/rows:(counts/rows)+1;
        map.put("counts",counts);
        map.put("places",places);
        map.put("totalPage",totalPage);
        map.put("page",page);
        return map;
    }
}
