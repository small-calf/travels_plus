package com.wyl.travels_plus.entity;/**
 * @Auther:小王
 * @Date:2020/8/22
 * @Description:travels_plus
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {
    private Boolean state = true;
    private String msg;
    private String userId;

}
