package org.yangxin.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yangxin.homepage.service.ICourseService;
import org.yangxin.imoochomepage.CourseInfo;
import org.yangxin.imoochomepage.CourseInfoRequest;

import java.util.Collections;
import java.util.List;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 17:06
 */
@Slf4j
@RestController
public class HomepageCourseController {
    private final ICourseService courseService;

    @Autowired
    public HomepageCourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    /**
     * 通过Id，获取课程信息
     *
     * @param id id
     * @return 课程信息
     */
    @GetMapping("/course/get")
    public CourseInfo getCourseInfo(Long id) {
        log.info("<homepage-course>: get course -> {}", id);

        if (id == null) {
            return CourseInfo.invalid();
        }

        return courseService.getCourseInfo(id);
    }

    @PostMapping("/course/list")
    public List<CourseInfo> listCourseInfo(@RequestBody CourseInfoRequest courseInfoRequest) {
        log.info("<homepage-course>: get courses -> {}", JSON.toJSONString(courseInfoRequest));

        if (courseInfoRequest == null) {
            return Collections.emptyList();
        }

        return courseService.listCourseInfo(courseInfoRequest);
    }
}
