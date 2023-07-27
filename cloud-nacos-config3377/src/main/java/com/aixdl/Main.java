package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * dataId的格式
 * ${prefix}-${spring.profile.active}.${file-extension}
 * prefix默认为spring.application.name的值，也可以通过配置项spring.cloud.nacos.config.prefix来配置。
 * spring.profile.active即为当前环境对应的profile，详情可以参考Spring Boot文档。 注意：当spring.profile.active为空时，对应的连接符-也将不存在，dataId的拼接格式变成${prefix}.${file-extension}
 * file-extension为配置内容的数据格式，可以通过配置项spring.cloud.nacos.config.file-extension来配置。目前只支持properties和yaml类型。
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main
{
    public static void main( String[] args )
    {
        SpringApplication.run(Main.class, args);
    }
}
