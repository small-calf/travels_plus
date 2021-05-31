package com.wyl.travels_plus.entity;/**
 * @Auther:小王
 * @Date:2020/8/30
 * @Description:travels_plus
 * @version:1.0
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Place {
    private String id;
    private String name;
    private String picpath;//景点图片
    @JsonFormat(pattern = "yyyy-MM-dd")//指定时间格式
    private String hottime;//旺季时间
    private Double hotticket;//旺季门票
    private Double dimticket;//淡季门票
    private String placedes;//描述
    private String provinceid;

}
