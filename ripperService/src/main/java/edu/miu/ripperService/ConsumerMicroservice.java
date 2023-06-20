package edu.miu.ripperService;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMicroservice {

	@Autowired
	private KafkaSender kafkaSender;

	@KafkaListener(topics = {"earthquake"})
	public void receive(@Payload String message) {
		message = message.replace("{,","{");
		//System.out.println(message);
	    //System.out.println("Receiver received message= "+ message);
	    //EarthQuake earthQuake1 = new EarthQuake("ak0237teb8pn", 2.7, "CA", LocalDateTime.now());
	    //earthQuakeRepository.save(earthQuake1);

		Gson g = new Gson();
		Earthquake data = g.fromJson(message, Earthquake.class);
//String id, String place, String time, double magnitude
		String state = "others";
		String[] strArr = data.getPlace().split(",");
		if(strArr.length == 2){
			state = strArr[1].trim();
		}
		else{
			state = data.getPlace();
		}
		ProcessedEarthquake pe = new ProcessedEarthquake(data.getId(),state,data.getTime(),data.getMagnitude());


		//Earthquake data = g.fromJson(message, Earthquake.class);
		//System.out.println("Id="+ data.getId() + "mag=" + data.getMagnitude() + "place=" + data.getPlace() + "time=" + data.getTime());
		System.out.println(pe.toString());
//		kafkaSender.send(pe.toString());




	}
}
