package com.ccy.homepage.service;

import com.alibaba.fastjson.JSON;
import com.ccy.homepage.Application;
import com.ccy.homepage.CourseInfosRequest;
import dao.HomepageCourseDao;
import entity.HomepageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import service.ICourseService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * @ClassName HomepageCourseServiceTest
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 19:50
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

    @Resource
    private HomepageCourseDao courseDao;

    @Resource
    private ICourseService courseService;

    @Test
    public void testCreateCourse(){
        HomepageCourse course1 = new HomepageCourse(
                "JDK11&12 新特性解读",
                0,
                "https://www.imooc.com/",
                "解读 JDK11 和 JDK12 的新版本特性"
        );
        HomepageCourse course2 = new HomepageCourse(
                "基于Spring Cloud微服务架构 广告系统设计与实现",
                1,
                "https://www.imooc.com/",
                "广告系统的设计与实现"
        );

        System.out.println(courseDao.saveAll(Arrays.asList(course1, course2)).size());
    }

    @Test
    public void testGetCourseInfo() {

        System.out.println(JSON.toJSONString(courseService.getCourseInfo(6L)));
        System.out.println(JSON.toJSONString(courseService.getCourseInfo(10L)));
    }

    @Test
    public void testGetCourseInfos() {

        System.out.println(JSON.toJSONString(courseService.getCourseInfos(
                new CourseInfosRequest(Arrays.asList(6L, 7L, 8L))
        )));
    }



}
