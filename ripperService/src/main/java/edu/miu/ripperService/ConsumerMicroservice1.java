package edu.miu.ripperService;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication

public class ConsumerMicroservice1 {
	
	
	public static void main(String[] args) {
        // Kafka consumer configuration
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "earthquakeGroup");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class.getName());

        // Create Kafka consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        // Subscribe to the topic(s) you want to consume from
        consumer.subscribe(Collections.singletonList("earthquake"));

        try {
            // Continuously poll for new records
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(100);

                // Process the received records
                for (ConsumerRecord<String, String> record : records) {
                	String key = record.key(); // Retrieve the key as a byte[]
                	String value = record.value(); // Retrieve the value as a byte[]

                    // Process the key and value as needed
                    System.out.println("Received record:");
                    System.out.println("Key: " + new String(key));
                    System.out.println("Value: " + new String(value));
                }
            }
        } finally {
            // Close the consumer when finished
            consumer.close();
        }
    }
	
	
	
	/*
	public static void main(String[] args) {
        SpringApplication.run(ConsumerMicroservice.class, args);
    }
	*/
	
	//@KafkaListener(topics = "earthquake", groupId = "earthquakeGroup")
	public void listen(ConsumerRecord<String, byte[]> record) {
		//System.out.println("Received data from Kafka: " + record);
		
		// Process the received byte[] message
        byte[] messageBytes = record.value();
        String message = new String(messageBytes);

        // Perform your desired operations with the message
        System.out.println("Received message: " + message);
	}
	
	//@KafkaListener(topics = "earthquakeTopic", groupId = "earthquakeGroup")
    public void listen22(@Payload edu.miu.ripperService.Metadata record) {
		System.out.println("Received data from Kafka: " + record);
	}
	
	//@KafkaListener(topics = "earthquakeTopic", groupId = "earthquakeGroup")
    public void listen111(ConsumerRecord<String, NewEarthquakeData> record) {
		NewEarthquakeData data = record.value();
        System.out.println("Received data from Kafka: " + data);

        // Process the necessary fields (magnitude, latitude, longitude, location)
        /*
        double magnitude = data.getProperties().getMagnitude();
        double latitude = data.getGeometry().getCoordinates().getLatitude();
        double longitude = data.getGeometry().getCoordinates().getLongitude();
        String location = data.getProperties().getPlace();
        */

        // Store the processed data in MongoDB
        /*
        MongoCollection<Document> collection = mongoDatabase.getCollection("earthquakeData");
        Document document = new Document()
                .append("magnitude", magnitude)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .append("location", location);
        collection.insertOne(document);
        System.out.println("Processed data stored in MongoDB: " + document);
        */

        
    }

}
