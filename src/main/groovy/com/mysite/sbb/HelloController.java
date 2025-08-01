package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Annotations on Java
@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SBB!";
    }

    @GetMapping("/jump")
    @ResponseBody
    public String jump() {
        return "점프 투 스프링 부트";
    }
}
