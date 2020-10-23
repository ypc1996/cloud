package com.example.invoker.controller;

import com.example.invoker.service.InvokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangpengcheng
 * @date 2020/10/23
 **/
@RestController
@Configuration
public class InvokerController {
    @Autowired
    private InvokeService invokeService;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/say/{name}")
    public String say(@PathVariable("name") String name){
        return invokeService.say(name);
    }

    @RequestMapping(value = "/router/{name}",method = RequestMethod.GET)
    public String router(@PathVariable("name") String name){
        String result = restTemplate.getForObject("http://service-provider/person/say/"+name,String.class);
        return result;
    }
}
