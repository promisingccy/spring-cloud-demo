package service;

import com.ccy.homepage.CourseInfo;
import com.ccy.homepage.CourseInfosRequest;

import java.util.List;

/**
 * @ClassName ICourseService
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 17:25
 * @Version 1.0
 **/
public interface ICourseService {

    //单一课程
    CourseInfo getCourseInfo(Long id);

    //课程列表
    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
