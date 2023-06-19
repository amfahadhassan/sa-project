package edu.miu.inputService;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonSerializer;

@SpringBootApplication
@EnableScheduling
public class EarthquakeDataProcessor {
    public static void main(String[] args) {
        SpringApplication.run(EarthquakeDataProcessor.class, args);
    }

    
}

@Component
class EarthquakeDataProducer {
	
	/*
    private final KafkaTemplate<String, NewEarthquakeData> kafkaTemplate;

    
    @Autowired
    public EarthquakeDataProducer(KafkaTemplate<String, NewEarthquakeData> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    */
    

	private final KafkaTemplate<String, edu.miu.inputService.Metadata> kafkaTemplate;
	
    @Autowired
    public EarthquakeDataProducer(KafkaTemplate<String, edu.miu.inputService.Metadata> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    
    
	/*
	private final KafkaTemplate<String, String> kafkaTemplate;
	
    @Autowired
    public EarthquakeDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    */

    @Scheduled(fixedDelay = 120000) // Fetch data every 2 minutes
    public void fetchAndPushDataToKafka() {
        RestTemplate restTemplate = new RestTemplate();
        /*
        EarthquakeData earthquakeData = restTemplate.getForObject(
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&limit=1",
                EarthquakeData.class);
        */
        
        /*
        NewEarthquakeData earthquakeData = restTemplate.getForObject(
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&limit=1",
                NewEarthquakeData.class);
        */
        
        /*
        String earthquakeData = restTemplate.getForObject(
                "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&limit=1",
                String.class);
        
        */
        
        //System.out.println(earthquakeData);
        //System.out.println(earthquakeData.getMetadata());
        
        edu.miu.inputService.Metadata meta = new edu.miu.inputService.Metadata();
        meta.setApi("dadadasd11");
        meta.setTitle("test11");
        //kafkaTemplate.send("earthquakeTopic", earthquakeData);
        //kafkaTemplate.send("earthquakeTopic", earthquakeData.getMetadata());
        kafkaTemplate.send("earthquakeTopic", meta);

        //kafkaTemplate.send("earthquakeTopic", earthquakeData);
        //System.out.println("Data pushed to Kafka: " + earthquakeData.getMetadata());
    }
}
