package org.yangxin.homepage.service;

import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.request.CourseInfoRequest;

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
    CourseInfoVO getCourseInfo(Long id);

    /**
     * 通过Ids，获取课程信息
     */
    List<CourseInfoVO> listCourseInfo(CourseInfoRequest courseInfoRequest);
}
