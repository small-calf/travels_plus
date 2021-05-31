package com.wyl.travels_plus.entity;/**
 * @Auther:小王
 * @Date:2020/8/23
 * @Description:travels_plus
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 省份列表
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Province {
    private String id;
    private String name;
    private String tags;
    private Integer placecounts;
}
