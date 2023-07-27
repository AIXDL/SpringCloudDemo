package com.aixdl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//开启nacos的服务发现
@EnableDiscoveryClient
public class Main
{
    public static void main( String[] args )
    {
        SpringApplication.run(Main.class,args);
    }
}
