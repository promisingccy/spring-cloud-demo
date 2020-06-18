package com.ccy.homepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName CourseInfosRequest
 * @Description //TODO
 * @Author ccy
 * @Date 2020/6/18 15:00
 * @Version 1.0
 **/

/**
 * 课程信息请求对象定义
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfosRequest {

    private List<Long> ids;

}
