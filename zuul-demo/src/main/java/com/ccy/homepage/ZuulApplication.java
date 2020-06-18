package com.ccy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName ZuulApplication
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/16 19:32
 * @Version 1.0
 **/
/**
 * 网关应用程序
 * EnableZuulProxy 当前应用是 zuul server
 * SpringCloudApplication 组合注解
 * */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class, args);
    }
}
