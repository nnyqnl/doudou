package com.wenqi.doudou.kafka;

import com.wenqi.doudou.kafka.interceptor.MyProducerInterceptor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerFastStart {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("linger.ms", 1);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, MyProducerInterceptor.class.getName());

        Producer<String, String> producer = new KafkaProducer<>(props);
        try {
//            Future<RecordMetadata> future = producer.send(new ProducerRecord<>("quickstart-events", "kafka-demo", "hello wenqi5"));
//            RecordMetadata recordMetadata = future.get();
//            System.out.println("topic:" + recordMetadata.topic());
//            System.out.println("partition:" + recordMetadata.partition());
//            System.out.println("offset:" + recordMetadata.offset());

            producer.send(new ProducerRecord<>("quickstart-events", "kafka-demo", "hello wenqi5"), (recordMetadata, e) -> {
                System.out.println("topic:" + recordMetadata.topic());
                System.out.println("partition:" + recordMetadata.partition());
                System.out.println("offset:" + recordMetadata.offset());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        producer.close();
    }
}
