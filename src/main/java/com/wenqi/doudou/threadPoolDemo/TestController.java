package com.wenqi.doudou.threadPoolDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("threadPool")
public class TestController {

    @Autowired
    @Qualifier("doudouThreadPool")
    private ThreadPoolExecutor  executor;
    @RequestMapping("test")
    public void test() {
        System.out.println(executor.getCorePoolSize());
        System.out.println(executor.getMaximumPoolSize());

        for (int i = 0; i < 5; i++) {
            executor.execute(() -> System.out.println(Thread.currentThread().getName()));
        }

    }
}
