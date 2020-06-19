package controller;

import com.alibaba.fastjson.JSON;
import com.ccy.homepage.CourseInfo;
import com.ccy.homepage.CourseInfosRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.ICourseService;

import java.util.List;

/**
 * @ClassName HomepageCourseController
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 17:49
 * @Version 1.0
 **/
@Slf4j
@RestController
public class HomepageCourseController {

    /** 课程服务接口 */
    private final ICourseService courseService;

    @Autowired
    public HomepageCourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    //访问注意添加接口前缀
    @GetMapping("/get/course")
    public CourseInfo getCourseInfo(Long id){
        log.info("<homepage-course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(
            @RequestBody CourseInfosRequest request
            ){
        log.info("<homepage-course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }
}
