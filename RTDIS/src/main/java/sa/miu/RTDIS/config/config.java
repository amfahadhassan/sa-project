package sa.miu.RTDIS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sa.miu.RTDIS.kafka.Sender;

@Configuration
public class config {

    @Bean
    public Sender sender() {
        return new Sender();
    }
}
