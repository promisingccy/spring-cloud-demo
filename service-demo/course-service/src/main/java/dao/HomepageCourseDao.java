package dao;

import entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName HomepageCourseDao
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 17:22
 * @Version 1.0
 **/
//JPA已经实现了一些curd基础方法 自定义方法在此实现
public interface HomepageCourseDao extends JpaRepository<HomepageCourse, Long> {
}
