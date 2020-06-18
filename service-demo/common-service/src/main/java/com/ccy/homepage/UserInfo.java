package com.ccy.homepage;

/**
 * @ClassName UserInfo
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 14:50
 * @Version 1.0
 **/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本用户信息
 * */
@Data  //get set
@NoArgsConstructor  //无参数构造函数
@AllArgsConstructor  //全参数构造函数
public class UserInfo {
    private long id;
    private String username;
    private String email;

    //无效用户信息
    public static UserInfo invalid(){
        return new UserInfo(-1L, "", "");
    }


}
