package org.yangxin.imoochomepage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 1. 只需要使用 @EnableEurekaServer 注解，就可以让应用变为 Eureka Server
 * 2. pom 文件中对应到 spring-cloud-starter-netflix-eureka-server
 *
 * @author yangxin
 * 2019/11/27 11:49
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
