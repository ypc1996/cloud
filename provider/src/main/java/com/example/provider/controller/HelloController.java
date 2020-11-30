package com.example.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangpengcheng
 * @ClassName HelloController
 * @Description:
 * @date 2020/11/1014:57
 */
@Controller
public class HelloController {
    @RequestMapping(value = "websocket",method = RequestMethod.GET)
    public String websocket(){
        return "websocket";
    }
}
