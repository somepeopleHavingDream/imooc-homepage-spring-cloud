package org.yangxin.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 入口
 *
 * @author yangxin
 * 2019/12/09 17:52
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {"org.yangxin.homepage"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
