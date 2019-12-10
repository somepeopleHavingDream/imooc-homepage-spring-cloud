package org.yangxin.homepage.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yangxin.homepage.Application;
import org.yangxin.homepage.dao.HomepageUserCourseDAO;
import org.yangxin.homepage.entity.HomepageUserCourse;
import org.yangxin.homepage.request.CreateUserRequest;
import org.yangxin.homepage.service.IUserService;
import org.yangxin.imoochomepage.vo.UserInfoVO;

import java.util.Arrays;
import java.util.List;

/**
 * 用户
 *
 * @author yangxin
 * 2019/12/10 13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Slf4j
public class UserServiceImplTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private HomepageUserCourseDAO homepageUserCourseDAO;

    @Test
//    @Transactional
    public void createUser() {
        UserInfoVO userInfoVO = userService.createUser(new CreateUserRequest("qiyi", "qiyi@imooc.com"));
        log.info("userInfoVO: [{}]", userInfoVO);
        Assert.assertNotNull(userInfoVO);
    }

    @Test
    public void getUserInfo() {
        UserInfoVO userInfoVO = userService.getUserInfo(6L);
        Assert.assertNotNull(userInfoVO);
    }

    @Test
    public void testCreateHomepageUserCourse() {
        HomepageUserCourse homepageUserCourse1 = HomepageUserCourse.builder()
                .userId(6L)
                .courseId(1L)
                .build();

        HomepageUserCourse homepageUserCourse2 = HomepageUserCourse.builder()
                .userId(6L)
                .courseId(2L)
                .build();

        List<HomepageUserCourse> homepageUserCourseList = homepageUserCourseDAO
                .saveAll(Arrays.asList(homepageUserCourse1, homepageUserCourse2));
        Assert.assertNotEquals(0, homepageUserCourseList.size());
    }
//
//    @Test
//    public void getUserCourseInfo() {
//    }
}
