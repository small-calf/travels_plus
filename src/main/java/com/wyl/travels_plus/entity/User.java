package com.wyl.travels_plus.entity;/**
 * @Auther:小王
 * @Date:2020/8/17
 * @Description:travels_plus
 * @version:1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
}
