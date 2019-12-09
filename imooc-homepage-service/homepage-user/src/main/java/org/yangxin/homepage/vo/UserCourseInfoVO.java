package org.yangxin.homepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.vo.UserInfoVO;

import java.util.Collections;
import java.util.List;

/**
 * 用户课程信息
 *
 * @author yangxin
 * 2019/12/07 15:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCourseInfoVO {
    /**
     * 用户信息
     */
    private UserInfoVO userInfoVO;

    /**
     * 课程信息
     */
    private List<CourseInfoVO> courseInfoVOS;

    /**
     * 不合法
     */
    public static UserCourseInfoVO invalid() {
        return new UserCourseInfoVO(UserInfoVO.invalid(), Collections.emptyList());
    }
}
