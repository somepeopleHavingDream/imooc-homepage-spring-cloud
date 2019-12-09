package org.yangxin.homepage.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.yangxin.homepage.client.CourseClient;
import org.yangxin.homepage.dao.HomepageUserCourseDAO;
import org.yangxin.homepage.dao.HomepageUserDAO;
import org.yangxin.homepage.entity.HomepageUser;
import org.yangxin.homepage.entity.HomepageUserCourse;
import org.yangxin.homepage.request.CreateUserRequest;
import org.yangxin.homepage.service.IUserService;
import org.yangxin.homepage.vo.UserCourseInfoVO;
import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.request.CourseInfoRequest;
import org.yangxin.imoochomepage.vo.UserInfoVO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 用户
 *
 * @author yangxin
 * 2019/12/09 16:00
 */
@Service
public class UserServiceImpl implements IUserService {
    private final HomepageUserDAO homepageUserDAO;
    private final HomepageUserCourseDAO homepageUserCourseDAO;
    private final CourseClient courseClient;

    public UserServiceImpl(HomepageUserDAO homepageUserDAO,
                           HomepageUserCourseDAO homepageUserCourseDAO,
                           CourseClient courseClient) {
        this.homepageUserDAO = homepageUserDAO;
        this.homepageUserCourseDAO = homepageUserCourseDAO;
        this.courseClient = courseClient;
    }

    @Override
    public UserInfoVO createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfoVO.invalid();
        }

        HomepageUser homepageUser = homepageUserDAO.findByUsername(request.getUsername());
        if (homepageUser != null) {
            return UserInfoVO.invalid();
        }

        HomepageUser newUser = homepageUserDAO.save(new HomepageUser(request.getUsername(), request.getEmail()));

        return new UserInfoVO(newUser.getId(), newUser.getUsername(), newUser.getEmail());
    }

    @Override
    public UserInfoVO getUserInfo(Long id) {
        Optional<HomepageUser> homepageUserOptional = homepageUserDAO.findById(id);
        if (!homepageUserOptional.isPresent()) {
            return UserInfoVO.invalid();
        }

        HomepageUser homepageUser = homepageUserOptional.get();
        return new UserInfoVO(homepageUser.getId(), homepageUser.getUsername(), homepageUser.getEmail());
    }

    @Override
    public UserCourseInfoVO getUserCourseInfo(Long id) {
        // 参数校验
        Optional<HomepageUser> homepageUserOptional = homepageUserDAO.findById(id);
        if (!homepageUserOptional.isPresent()) {
            return UserCourseInfoVO.invalid();
        }

        // 用户信息
        HomepageUser homepageUser = homepageUserOptional.get();
        UserInfoVO userInfoVO = new UserInfoVO(homepageUser.getId(), homepageUser.getUsername(), homepageUser.getEmail());

        // 用户所对应的课程信息
        List<HomepageUserCourse> homepageUserCourseList = homepageUserCourseDAO.findAllByUserId(id);
        if (CollectionUtils.isEmpty(homepageUserCourseList)) {
            return new UserCourseInfoVO(userInfoVO, Collections.emptyList());
        }

        List<CourseInfoVO> courseInfoVOList = courseClient.listCourseInfo(new CourseInfoRequest(homepageUserCourseList.stream()
                .map(HomepageUserCourse::getCourseId)
                .collect(Collectors.toList())));

        return new UserCourseInfoVO(userInfoVO, courseInfoVOList);
    }
}
