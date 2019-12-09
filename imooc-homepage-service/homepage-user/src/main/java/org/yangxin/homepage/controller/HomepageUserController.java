package org.yangxin.homepage.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yangxin.homepage.request.CreateUserRequest;
import org.yangxin.homepage.service.IUserService;
import org.yangxin.homepage.vo.UserCourseInfoVO;
import org.yangxin.imoochomepage.vo.UserInfoVO;

/**
 * 用户
 *
 * @author yangxin
 * 2019/12/09 16:30
 */
@Slf4j
@RestController
public class HomepageUserController {
    private final IUserService userService;

    @Autowired
    public HomepageUserController(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 创建用户
     */
    @PostMapping("/user/create")
    public UserInfoVO createUser(@RequestBody CreateUserRequest request) {
        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    /**
     * 得到用户信息
     */
    @GetMapping("/user/get")
    public UserInfoVO getUserInfo(Long id) {
        log.info("<homepage-user>: get user -> {}", id);
        return userService.getUserInfo(id);
    }

    /**
     * 获得用户课程信息
     */
    @GetMapping("/user/course/list")
    public UserCourseInfoVO getUserCourseInfo(Long id) {
        log.info("<homepage-user>: get user course info -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
