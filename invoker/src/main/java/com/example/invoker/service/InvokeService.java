package com.example.invoker.service;

import com.example.invoker.fallback.InvokeServiceFallBackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangpengcheng
 * @date 2020/10/23
 **/
@Component
@FeignClient(value = "service-provider",fallback = InvokeServiceFallBackImpl.class)
public interface InvokeService {
    /**
     * say
     * @param name
     * @return
     */
    @GetMapping("/person/say/{name}")
    String say(@PathVariable("name") String name);
}
