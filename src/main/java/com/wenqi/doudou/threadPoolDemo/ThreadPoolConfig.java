package com.wenqi.doudou.threadPoolDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class ThreadPoolConfig {

    @Bean
    public ThreadPoolExecutor doudouThreadPool() {
        return new ThreadPoolExecutor(5, 7, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue(3), new CustomizableThreadFactory("doudou-pool-"));

    }


}
