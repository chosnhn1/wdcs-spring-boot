package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/sample")
@Controller
public class SampleController {

//    Quiz answer: it already has requestmapping, so proper mapping string is
//    not @GetMapping("/sample/hello"), but this:
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello Sample";
    }
}
