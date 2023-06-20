package sa.miu.RTDIS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sa.miu.RTDIS.kafka.Sender;
import sa.miu.RTDIS.repo.EarthquakeRepository;
import sa.miu.RTDIS.service.EarthquakeService;
import sa.miu.RTDIS.service.EarthquakeServiceImpl;

@Configuration
public class config {
    @Bean
    public Sender sender() {
        return new Sender();
    }

    @Bean
    public EarthquakeService earthquakeService(EarthquakeRepository earthquakeRepository) {
        return new EarthquakeServiceImpl();
    }
}
