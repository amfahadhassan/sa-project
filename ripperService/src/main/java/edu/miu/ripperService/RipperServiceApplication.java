package edu.miu.ripperService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class RipperServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RipperServiceApplication.class, args);
		System.out.println("========Consumer+Ripper========");
	}

}
