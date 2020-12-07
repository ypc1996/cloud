package com.example.provider.controller;

import com.example.provider.listener.WorkerInterface;
import com.example.provider.mapper.UserMapper;
import com.example.provider.model.Shop;
import com.example.provider.model.SysRole;
import com.example.provider.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangpengcheng
 * @ClassName TestController
 * @Description:
 * @date 2020/11/517:05
 */

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "test01",method = RequestMethod.GET)
    public String test01(){
        return "test01";
    }
    @RequestMapping(value = "test02",method = RequestMethod.GET)
    public String test02(){
        User user = userMapper.selectById(1);
        return "test02";
    }

    @RequestMapping("test03")
    public void sendMessage(){
//        rabbitTemplate.convertAndSend("hello","hello world");
        rabbitTemplate.convertAndSend("logs","info","hello world");
    }



    public static void test(WorkerInterface workerInterface){
        workerInterface.doSomeThings();
    }

    public static void main(String[] args) {
        Shop shop=new Shop();
        Shop.Car.test();
        Shop.Car car=new Shop.Car();
        car.test2();
        Shop.Bus bus=shop.new Bus();
        bus.test();

        SysRole sysRole1 =new SysRole();
        sysRole1.setId(1);
        sysRole1.setRoleName("a");
        sysRole1.setSuccess(true);
        SysRole sysRole =new SysRole();
        sysRole.setId(1);
        sysRole.setRoleName("a");
        sysRole.setSuccess(true);
        System.out.println(sysRole1.equals(sysRole));

        WorkerInterface workerInterface= () -> {

        };
        test(() -> {
            System.out.println("111");
        });
    }

}
