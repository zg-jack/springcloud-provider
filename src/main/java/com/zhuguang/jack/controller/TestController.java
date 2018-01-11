package com.zhuguang.jack.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuguang.jack.bean.ConsultContent;
import com.zhuguang.jack.conf.DataSourceProperties;
import com.zhuguang.jack.service.CommonService;

@RestController
public class TestController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    DataSourceProperties dataSourceProperties;
    
    @Value("${username}")
    private String username;
    
    @Autowired
    CommonService commonService;
    
    @Autowired
    private DiscoveryClient client;
    
    @RequestMapping("/index")
    public String index() {
        return dataSourceProperties.getDriverClassName() + ":"
                + dataSourceProperties.getUrl() + ":"
                + dataSourceProperties.getPassword() + ":"
                + dataSourceProperties.getUsername() + ":" + username;
    }
    
    @RequestMapping("/queryContents")
    public ResponseEntity<List<ConsultContent>> queryContents() {
        return new ResponseEntity<List<ConsultContent>>(
                commonService.queryContent(), HttpStatus.OK);
    }
    
    @RequestMapping("/info")
    public String info() {
        ServiceInstance instance = client.getLocalServiceInstance();
        return instance.getHost() + "--" + instance.getPort() + "--"
                + instance.getServiceId();
    }
}
