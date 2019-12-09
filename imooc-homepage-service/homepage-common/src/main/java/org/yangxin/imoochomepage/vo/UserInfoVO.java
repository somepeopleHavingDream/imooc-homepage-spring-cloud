package org.yangxin.imoochomepage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基本的用户信息
 *
 * @author yangxin
 * 2019/12/04 15:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {
    /**
     * Id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 邮件
     */
    private String email;

    public static UserInfoVO invalid() {
        return new UserInfoVO(-1L, "", "");
    }
}
