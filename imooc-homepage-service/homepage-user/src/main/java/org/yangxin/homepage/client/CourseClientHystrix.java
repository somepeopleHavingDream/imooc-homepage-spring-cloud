package org.yangxin.homepage.client;

import org.springframework.stereotype.Component;
import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.request.CourseInfoRequest;

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
    public CourseInfoVO getCourseInfo(Long id) {
        return CourseInfoVO.invalid();
    }

    @Override
    public List<CourseInfoVO> listCourseInfo(CourseInfoRequest courseInfoRequest) {
        return Collections.emptyList();
    }
}
