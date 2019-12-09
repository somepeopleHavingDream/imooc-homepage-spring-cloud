package org.yangxin.homepage.client;

import org.springframework.stereotype.Component;
import org.yangxin.imoochomepage.CourseInfo;
import org.yangxin.imoochomepage.CourseInfoRequest;

import java.util.Collections;
import java.util.List;

/**
 * 熔断降级策略
 *
 * @author yangxin
 * 2019/12/09 15:42
 */
@Component
public class CourseClientHystrix implements CourseClient {
    @Override
    public CourseInfo getCourseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> listCourseInfo(CourseInfoRequest courseInfoRequest) {
        return Collections.emptyList();
    }
}
