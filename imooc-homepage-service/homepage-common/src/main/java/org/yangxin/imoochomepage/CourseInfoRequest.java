package org.yangxin.imoochomepage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 课程信息请求对象
 *
 * @author yangxin
 * 2019/12/04 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfoRequest {
    /**
     * ids
     */
    private List<Long> ids;
}
