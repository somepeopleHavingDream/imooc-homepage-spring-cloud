package org.yangxin.homepage.service;

import org.yangxin.homepage.request.CreateUserRequest;
import org.yangxin.homepage.vo.UserCourseInfoVO;
import org.yangxin.imoochomepage.vo.UserInfoVO;

/**
 * 用户
 *
 * @author yangxin
 * 2019/12/09 15:55
 */
public interface IUserService {
    /**
     * 创建用户
     */
    UserInfoVO createUser(CreateUserRequest request);

    /**
     * 根据Id，获取用户信息
     *
     * @param id id
     * @return 用户信息
     */
    UserInfoVO getUserInfo(Long id);

    /**
     * 获取用户课程信息
     *
     * @param id 用户Id
     * @return 用户课程信息
     */
    UserCourseInfoVO getUserCourseInfo(Long id);
}
