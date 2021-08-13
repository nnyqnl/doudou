package com.wenqi.doudou.kafka.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class MyProducerInterceptor implements ProducerInterceptor<String, String> {
    private volatile long successNum = 0;
    private volatile long failureNum = 0;

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        return new ProducerRecord(producerRecord.topic(), producerRecord.partition(), producerRecord.timestamp(), producerRecord.key(), "prefix-" + producerRecord.value());
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        if (e == null) successNum++;
        else failureNum++;
    }

    @Override
    public void close() {
        System.out.printf("成功：%d%n", successNum);
        System.out.printf("失败：%d%n", failureNum);
        System.out.printf("发送成功率：%s%n", (double) successNum / (successNum + failureNum));
    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
