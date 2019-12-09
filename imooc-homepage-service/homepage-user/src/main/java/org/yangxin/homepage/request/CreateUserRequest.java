package org.yangxin.homepage.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * 创建用户请求对象定义
 *
 * @author yangxin
 * 2019/12/09 15:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
    /**
     * 用户名
     */
    private String username;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 请求有效性验证
     *
     * @return 是否有效
     */
    public Boolean validate() {
        return !StringUtils.isEmpty(username) && !StringUtils.isEmpty(email);
    }
}
