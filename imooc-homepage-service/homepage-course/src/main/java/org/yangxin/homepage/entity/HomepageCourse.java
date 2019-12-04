package org.yangxin.homepage.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12/04 15:59
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "homepage_course")
public class HomepageCourse {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 课程名称
     */
    @Basic
    @Column(name = "course_name", nullable = false)
    private String courseName;

    /**
     * 课程类型：0（免费课），1（实战课）
     */
    @Basic
    @Column(name = "course_type", nullable = false)
    private Integer courseType;

    /**
     * 课程图标
     */
    @Basic
    @Column(name = "course_icon", nullable = false)
    private String courseIcon;

    /**
     * 课程介绍
     */
    @Basic
    @Column(name = "course_intro", nullable = false)
    private String courseIntroduction;

    /**
     * 创建时间
     */
    @Basic
    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间
     */
    @Basic
    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;

    public HomepageCourse(String courseName, Integer courseType, String courseIcon, String courseIntroduction) {
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseIcon = courseIcon;
        this.courseIntroduction = courseIntroduction;
    }

    /**
     * 返回一个无效的课程信息
     */
    public static HomepageCourse invalid() {
        HomepageCourse homepageCourse = new HomepageCourse("",
                0,
                "",
                "");
        homepageCourse.setId(-1L);
        return homepageCourse;
    }
}
