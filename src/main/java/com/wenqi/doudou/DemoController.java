package com.example.hero;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping
    public String method() {
        System.out.println("request");
        return "aaa";
    }


}
