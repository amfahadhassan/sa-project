package sa.miu.RTDIS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sa.miu.RTDIS.kafka.EarthquakeChangesProducer;
import sa.miu.RTDIS.logging.ILogger;

import java.io.IOException;

@RestController
@RequestMapping("/rtdis")
public class RtdisController {
    @Autowired
    private ILogger logger;
    @Autowired
    private EarthquakeChangesProducer earthquakeChangesProducer;

    @GetMapping("/start")
    public void start() throws IOException, InterruptedException {
        logger.info("Kafka Streaming Started...");

        earthquakeChangesProducer.sendMessage();
    }
}
