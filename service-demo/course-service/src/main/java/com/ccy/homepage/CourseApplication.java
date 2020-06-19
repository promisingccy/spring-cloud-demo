package com.ccy.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @ClassName CourseApplication
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 16:08
 * @Version 1.0
 **/
@EnableJpaAuditing  //自动更新 时间字段
@EnableEurekaClient
@SpringBootApplication
public class CourseApplication {
    public static void main(String[] args){
        SpringApplication.run(CourseApplication.class, args);
    }
}
