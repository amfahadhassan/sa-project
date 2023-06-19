package sa.miu.RTDIS.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "earthquake";

    public Sender(){}
    public void send(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
