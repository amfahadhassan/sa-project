package edu.miu.ripperService;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMicroservice {
	

	@KafkaListener(topics = {"earthquake"})
	public void receive(@Payload String message) {
	    System.out.println("Receiver received message= "+ message);
	    //EarthQuake earthQuake1 = new EarthQuake("ak0237teb8pn", 2.7, "CA", LocalDateTime.now());
	    //earthQuakeRepository.save(earthQuake1);
	}
}
