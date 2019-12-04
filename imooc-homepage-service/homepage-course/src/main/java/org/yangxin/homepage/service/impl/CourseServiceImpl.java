package org.yangxin.homepage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.yangxin.homepage.dao.HomepageCourseDAO;
import org.yangxin.homepage.entity.HomepageCourse;
import org.yangxin.homepage.service.ICourseService;
import org.yangxin.imoochomepage.CourseInfo;
import org.yangxin.imoochomepage.CourseInfoRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 16:27
 */
@Service
public class CourseServiceImpl implements ICourseService {
    private final HomepageCourseDAO homepageCourseDAO;

    @Autowired
    public CourseServiceImpl(HomepageCourseDAO homepageCourseDAO) {
        this.homepageCourseDAO = homepageCourseDAO;
    }

    @Override
    public CourseInfo getCourseInfo(Long id) {
        Optional<HomepageCourse> homepageCourseOptional = homepageCourseDAO.findById(id);
        return buildCourseInfo(homepageCourseOptional.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> listCourseInfo(CourseInfoRequest courseInfoRequest) {
        if (CollectionUtils.isEmpty(courseInfoRequest.getIds())) {
            return Collections.emptyList();
        }

        List<HomepageCourse> homepageCourseList = homepageCourseDAO.findAllById(courseInfoRequest.getIds());
        return homepageCourseList.stream()
                .map(this::buildCourseInfo)
                .collect(Collectors.toList());
    }

    /**
     * 根据数据记录构造对象信息
     */
    private CourseInfo buildCourseInfo(HomepageCourse homepageCourse) {
        return CourseInfo.builder()
                .id(homepageCourse.getId())
                .courseName(homepageCourse.getCourseName())
                .courseType(homepageCourse.getCourseType() == 0 ? "免费课程" : "实战课程")
                .courseIcon(homepageCourse.getCourseIcon())
                .courseIntroduction(homepageCourse.getCourseIntroduction())
                .build();
    }
}
