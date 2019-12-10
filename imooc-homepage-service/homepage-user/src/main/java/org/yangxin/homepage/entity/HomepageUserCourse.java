package org.yangxin.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户课程
 *
 * @author yangxin
 * 2019/12/06 15:44
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_user_course")
@Builder
public class HomepageUserCourse {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 用户Id
     */
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 课程Id
     */
    @Basic
    @Column(name = "course_id", nullable = false)
    private Long courseId;

    /**
     * 创建时间
     */
    @Basic
    @CreatedDate
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @Basic
    @LastModifiedDate
    @Column(name = "update_time", nullable = false)
    private Date updateTime;
}
