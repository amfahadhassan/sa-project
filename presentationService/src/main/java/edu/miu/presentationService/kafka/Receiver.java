package edu.miu.presentationService.kafka;

import edu.miu.presentationService.domain.EarthQuake;
import edu.miu.presentationService.repository.EarthQuakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class Receiver {

    @Autowired
    private EarthQuakeRepository earthQuakeRepository;

    @KafkaListener(topics = {"earthquakeprocessed"})
    public void receive(@Payload String message) {
        System.out.println("Receiver received message= "+ message);
//        EarthQuake earthQuake1 = new EarthQuake("ak0237teb8pn", 2.7, "CA", LocalDateTime.now());
//        earthQuakeRepository.save(earthQuake1);
    }

}
