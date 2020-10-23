package com.example.provider.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangpengcheng
 * @date 2020/10/23
 **/
@RestController
@RequestMapping("/person")
public class ProviderController {
    @RequestMapping(value = "/say/{name}",method = RequestMethod.GET)
    public String findName(@PathVariable("name") String name){
        return name;
    }
}
