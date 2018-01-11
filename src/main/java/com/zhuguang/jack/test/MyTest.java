package com.zhuguang.jack.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.conf.DataSourceProperties;
import com.zhuguang.jack.service.CommonService;
import com.zhuguang.jack.start.SpringBootSampleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
//这个注解必须告诉junit，springboot的启动类是哪一个
//@SpringApplicationConfiguration(classes = SpringBootSampleApplication.class)
//这个是junit需要模拟一个ServletContext
@SpringBootTest(classes = SpringBootSampleApplication.class)
@WebAppConfiguration
public class MyTest {
    
    @Autowired
    DataSourceProperties dataSourceProperties;
    
    @Value("${username}")
    private String username;
    
    @Autowired
    CommonService commonService;
    
    @Autowired
    private DiscoveryClient client;
    
    @Test
    public void test1() {
        System.out.println(dataSourceProperties.getDriverClassName());
        System.out.println(username);
        ServiceInstance instance = client.getLocalServiceInstance();
        System.out.println(instance.getHost() + "--" + instance.getPort()
                + "--" + instance.getServiceId());
    }
    
    @Test
    public void test2() {
        List<ConsultContent> contents = commonService.queryContent();
        System.out.println(contents);
        for (ConsultContent content : contents) {
            System.out.println(content.getContent());
        }
    }
}
