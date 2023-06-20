package edu.miu.ripperService.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class KafkaSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "earthquakeprocessed";

    public KafkaSender(){}
    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
