package org.yangxin.homepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * SpringBoot启动入口
 *
 * @author yangxin
 * 2019/12/04 15:31
 */
@EnableJpaAuditing
@EnableEurekaClient
@SpringBootApplication
public class HomepageCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomepageCourseApplication.class, args);
    }
}
