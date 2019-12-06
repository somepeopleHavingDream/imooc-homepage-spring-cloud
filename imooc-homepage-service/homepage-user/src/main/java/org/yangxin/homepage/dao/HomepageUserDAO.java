package org.yangxin.homepage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yangxin.homepage.entity.HomepageUser;

/**
 * 用户
 *
 * @author yangxin
 * 2019/12/06 15:49
 */
public interface HomepageUserDAO extends JpaRepository<HomepageUser, Long> {

    /**
     * 通过用户名寻找数据记录
     *
     * @param username 用户名
     * @return 用户记录
     */
    HomepageUser findByUsername(String username);
}
