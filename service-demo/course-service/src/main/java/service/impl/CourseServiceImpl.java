package service.impl;

import com.ccy.homepage.CourseInfo;
import com.ccy.homepage.CourseInfosRequest;
import dao.HomepageCourseDao;
import entity.HomepageCourse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import service.ICourseService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName CourseServiceImpl
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 17:28
 * @Version 1.0
 **/
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    //通过构造函数的方式注入 HomepageCourseDao
    private final HomepageCourseDao homepageCourseDao;

    @Autowired
    public CourseServiceImpl(HomepageCourseDao homepageCourseDao) {
        this.homepageCourseDao = homepageCourseDao;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        //获取数据
        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        //如果为空 返回 orElse  不为空返回 course
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        //判空
        if(CollectionUtils.isEmpty(request.getIds())){
            return Collections.emptyList();
        }
        //获取课程列表
        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());
        //java8语法 类似php array_map
        return courses.stream()
                .map(this::buildCourseInfo)  //执行方法
                .collect(Collectors.toList());//转list
    }

    //实体对象 -> VO对象
    private CourseInfo buildCourseInfo(HomepageCourse course){

        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType() == 0 ? "免费课程" : " 实战课程")
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
