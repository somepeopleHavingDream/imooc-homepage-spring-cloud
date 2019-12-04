package org.yangxin.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yangxin.homepage.entity.HomepageCourse;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 16:17
 */
public interface HomepageCourseDAO extends JpaRepository<HomepageCourse, Long> {
}
