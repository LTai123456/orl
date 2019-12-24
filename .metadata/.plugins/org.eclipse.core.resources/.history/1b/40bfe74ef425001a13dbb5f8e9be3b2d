package com.example.demo;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/hello")

@RefreshScope
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        @SuppressWarnings("deprecation")
		ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        return "Hello World"+"xxx";  
    }
    @GetMapping("/page")
    public String getPage(@RequestParam(value="sb",required=false) Integer sb) {
		return null;
    }
    @ApiOperation(value = "根据ID查询用户信息",notes = "根据用户ID从数据库中查询用户信息")
    @GetMapping(value = "/user",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<UserBean> queryUser(@ApiParam(name = "id",required = true,value = "用户ID") @RequestParam(value = "id")Integer userId){
        Response<UserBean> response = new Response<>();
        UserBean yserBean=new UserBean();
        yserBean.getAge();
        return response;
    }
    
}
