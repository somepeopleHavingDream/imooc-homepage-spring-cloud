package org.yangxin.homepagezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关应用程序
 * EnableZuulProxy：标识当前的应用是 Zuul Server
 * SpringCloudApplication：用于简化配置的组合注解
 *
 * @author yangxin
 * 2019/11/28 17:23
 */
@EnableZuulProxy
@SpringCloudApplication
public class ZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGatewayApplication.class, args);
    }
}
