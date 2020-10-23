package com.example.invoker.fallback;

import com.example.invoker.service.InvokeService;
import org.springframework.stereotype.Component;

/**
 * @author yangpengcheng
 * @date 2020/10/23
 **/
@Component
public class InvokeServiceFallBackImpl implements InvokeService {
    @Override
    public String say(String name) {
        return name+":熔断默认方法";
    }
}
