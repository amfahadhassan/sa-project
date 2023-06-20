package sa.miu.RTDIS.kafka;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sa.miu.RTDIS.domain.Earthquake;
import sa.miu.RTDIS.mapper.EarthquakeMapper;
import sa.miu.RTDIS.service.EarthquakeService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@Service
public class EarthquakeChangesProducer {
    @Autowired
    private Sender sender;
    @Autowired
    private EarthquakeService earthquakeService;

    private static final int INTERVAL_MS = 10000;   // 10 seconds

    public void sendMessage() throws IOException, InterruptedException {

        int count = 1;

        while (true) {
            System.out.println("Producing " + count + "- Earthquake Stream");
            URL url = new URL("https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&limit=1");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            in.close();
            con.disconnect();

            JSONObject jsonObject = new JSONObject(content.toString());

            Object array = jsonObject.get("features");

            Gson gson = new Gson();

            // Define the type of the array using TypeToken
            TypeToken<Object[]> token = new TypeToken<Object[]>() {
            };

            // Convert the JSON string to an array of objects
            Object[] myArray = gson.fromJson(array.toString(), token.getType());

            // Convert the first object to a JSON object
            String jsonString = gson.toJson(myArray[0]);

            // Parse the JSON string into a JsonObject
            JsonObject jsonObjectGson = gson.fromJson(jsonString, JsonObject.class);

            Earthquake earthquake = EarthquakeMapper.convertJsontoEarthquakeDto(jsonObjectGson);

            //save to database
            Earthquake saved = earthquakeService.save(earthquake);
            sender.send(earthquake.toString());

            // earthquake data
            System.out.println(saved.toString());

            count++;
            Thread.sleep(INTERVAL_MS);
        }
    }
}
