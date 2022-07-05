package com.wenqi.doudou.threadPoolDemo.countdownlatch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestW {

    @Test
    void test() throws InterruptedException {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(5);
        List<Thread> works = Stream
                .generate(() -> new Thread(new Worker(list, countDownLatch)))
                .limit(5)
                .collect(Collectors.toList());

        works.forEach(Thread::start);
        countDownLatch.await();
        list.add("1");
        System.out.println(list);
        assertEquals(6, list.size());
    }
}
