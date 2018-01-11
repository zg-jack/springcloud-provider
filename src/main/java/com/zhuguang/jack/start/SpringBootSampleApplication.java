package com.zhuguang.jack.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.zhuguang.jack.conf.DataSourceProperties;

@SpringBootApplication(scanBasePackages = {"com.zhuguang.jack"})
//启动配置属性类
@EnableConfigurationProperties(DataSourceProperties.class)
@EnableEurekaClient
@MapperScan("com.zhuguang.jack.dao")
public class SpringBootSampleApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }
}
