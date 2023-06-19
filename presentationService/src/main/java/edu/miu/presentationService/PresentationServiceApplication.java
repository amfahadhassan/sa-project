package edu.miu.presentationService;

import edu.miu.presentationService.repository.EarthQuakeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableMongoRepositories
@EnableKafka
public class PresentationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(PresentationServiceApplication.class, args);
	}

}
