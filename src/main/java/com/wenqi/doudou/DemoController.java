package com.wenqi.doudou;

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

    @RequestMapping("/hello")
    public String helloHtml() {
        return "/index.html";
    }

    public static void main(String[] args) {
        try {
            System.out.println(1111);
            try {
                System.out.println(22222);
                int a = 1 / 0;
            } finally {
                System.out.println(333);
            }
            System.out.println(4444);
        } catch (Exception e) {
            System.out.println(5555);
        }
    }

}
