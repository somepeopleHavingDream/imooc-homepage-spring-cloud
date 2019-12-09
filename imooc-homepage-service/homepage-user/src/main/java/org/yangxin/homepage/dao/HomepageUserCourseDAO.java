package org.yangxin.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yangxin.homepage.entity.HomepageUserCourse;

import java.util.List;

/**
 * 用户课程
 *
 * @author yangxin
 * 2019/12/06 15:52
 */
public interface HomepageUserCourseDAO extends JpaRepository<HomepageUserCourse, Long> {
    /**
     * 通过用户Id，寻找用户课程记录
     *
     * @param userId 用户Id
     * @return 用户课程记录
     */
    List<HomepageUserCourse> findAllByUserId(Long userId);
}
