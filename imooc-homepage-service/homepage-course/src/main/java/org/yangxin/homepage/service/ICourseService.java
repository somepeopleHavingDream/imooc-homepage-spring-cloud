package org.yangxin.homepage.service;

import org.yangxin.imoochomepage.CourseInfo;
import org.yangxin.imoochomepage.CourseInfoRequest;

import java.util.List;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 16:24
 */
public interface ICourseService {
    /**
     * 通过Id，获取课程信息
     *
     * @param id id
     * @return 课程信息
     */
    CourseInfo getCourseInfo(Long id);

    /**
     * 通过Ids，获取课程信息
     */
    List<CourseInfo> listCourseInfo(CourseInfoRequest courseInfoRequest);
}
