package org.yangxin.homepage.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yangxin.homepage.Application;
import org.yangxin.homepage.dao.HomepageCourseDAO;
import org.yangxin.homepage.entity.HomepageCourse;
import org.yangxin.homepage.service.ICourseService;
import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.request.CourseInfoRequest;

import java.util.List;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 17:24
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CourseServiceImplTest {
    @Autowired
    private HomepageCourseDAO homepageCourseDAO;
    @Autowired
    private ICourseService courseService;

    @Test
    public void getCourseInfo() {
        CourseInfoVO courseInfoVO = courseService.getCourseInfo(1L);
        log.info("courseInfoVO: [{}]", JSON.toJSONString(courseInfoVO));

        Assert.assertNotNull(courseInfoVO);
    }

    @Test
    public void listCourseInfo() {
        List<CourseInfoVO> courseInfoVOList = courseService
                .listCourseInfo(new CourseInfoRequest(Lists.newArrayList(1L, 2L)));
        log.info("courseInfoVOList: [{}]", JSON.toJSONString(courseInfoVOList));

        Assert.assertNotNull(courseInfoVOList);
    }

    @Test
    public void testCreateCourseInfo() {
        HomepageCourse homepageCourse1 = new HomepageCourse("JDK11&12 新特性解读",
                0,
                "https://www.imooc.com",
                "解读JDK11和JDK12的新版本特性");
        HomepageCourse homepageCourse2 = new HomepageCourse("基于SpringCloud微服务架构 广告系统设计与实现",
                1,
                "https://www.imooc.com",
                "广告系统的设计与实现");
        List<HomepageCourse> homepageCourseList = homepageCourseDAO.saveAll(Lists.newArrayList(homepageCourse1,
                homepageCourse2));

        Assert.assertEquals(2, homepageCourseList.size());
    }
}
