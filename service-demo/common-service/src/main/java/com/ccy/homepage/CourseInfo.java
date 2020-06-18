package com.ccy.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseInfo
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 14:54
 * @Version 1.0
 **/

/**
 * 课程信息
 * */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {

    private Long id;
    private String courseName;//
    private String courseType;//
    private String courseIcon;//
    private String courseIntro;//

    public static CourseInfo invalid(){
        return new CourseInfo(-1L, "", "", "", "");
    }



}
