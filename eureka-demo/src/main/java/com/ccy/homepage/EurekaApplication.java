package com.ccy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApplication
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/15 17:08
 * @Version 1.0
 **/
/**
 * 注解 @EnableEurekaServer 对应pom的
 * spring-cloud-starter-netflix-eureka-server
 * 使应用成为 eureka server
 * */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args){
        SpringApplication.run(EurekaApplication.class, args);
    }
}
