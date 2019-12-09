package org.yangxin.imoochomepage.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程信息
 *
 * @author yangxin
 * 2019/12/04 15:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoVO {
    /**
     * Id
     */
    private Long id;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程图标
     */
    private String courseIcon;

    /**
     * 课程类型（免费课程，实战课程）
     */
    private String courseType;

    /**
     * 课程介绍
     */
    private String courseIntroduction;

    public static CourseInfoVO invalid() {
        return new CourseInfoVO(-1L,
                "",
                "",
                "",
                "");
    }
}
