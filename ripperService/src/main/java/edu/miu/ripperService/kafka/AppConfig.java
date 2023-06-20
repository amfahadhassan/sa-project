package edu.miu.ripperService.kafka;

import edu.miu.ripperService.kafka.KafkaSender;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AppConfig {
    @Bean
    public KafkaSender sender() {
        return new KafkaSender();
    }

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("earthquakeprocessed")
                .build();
    }
}
