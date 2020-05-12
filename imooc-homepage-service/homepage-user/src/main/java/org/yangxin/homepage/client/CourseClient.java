package org.yangxin.homepage.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.yangxin.imoochomepage.vo.CourseInfoVO;
import org.yangxin.imoochomepage.request.CourseInfoRequest;

import java.util.List;

/**
 * 课程
 *
 * @author yangxin
 * 2019/12
 */
@FeignClient(value = "eureka-client-homepage-course", fallback = CourseClientHystrix.class)
public interface CourseClient {

    /**
     * 查询单个课程的信息
     *
     * @param id 课程Id
     * @return 课程信息
     */
    @GetMapping("/homepage-course/course/get")
    CourseInfoVO getCourseInfo(Long id);

    /**
     * 查询多个课程的信息
     */
    @PostMapping("/homepage-course/course/list")
    List<CourseInfoVO> listCourseInfo(@RequestBody CourseInfoRequest courseInfoRequest);
}
