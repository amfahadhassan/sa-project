package sa.miu.RTDIS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import sa.miu.RTDIS.kafka.EarthquakeChangesProducer;

@SpringBootApplication
@EnableKafka
public class RtdisApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtdisApplication.class, args);
    }
}
