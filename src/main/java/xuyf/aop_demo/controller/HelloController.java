package xuyf.aop_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志切面
 */

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){
        return name;
    }

    @GetMapping("/hello2")
    public String hello2(){
        System.out.println("hello21");
        return "hello2";
    }
}
