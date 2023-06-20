package sa.miu.RTDIS.mapper;

import com.google.gson.JsonObject;
import org.json.JSONObject;
import sa.miu.RTDIS.domain.Earthquake;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class EarthquakeMapper {
    public static Earthquake convertJsontoEarthquakeDto(JsonObject json) {

        // id
        String id = json.get("id").getAsString();

        // properties
        double magnitude = json.getAsJsonObject("properties").get("mag").getAsDouble();
        String place = json.getAsJsonObject("properties").get("place").getAsString();
        String time = dateTimeFormatter(json.getAsJsonObject("properties").get("time").getAsLong());
        String magType = json.getAsJsonObject("properties").get("magType").getAsString();
        String type = json.getAsJsonObject("properties").get("type").getAsString();
        String title = json.getAsJsonObject("properties").get("title").getAsString();
        String types = json.getAsJsonObject("properties").get("types").getAsString();
        String code = json.getAsJsonObject("properties").get("code").getAsString();
        String sources = json.getAsJsonObject("properties").get("sources").getAsString();
        String status = json.getAsJsonObject("properties").get("status").getAsString();
        double tsunami = json.getAsJsonObject("properties").get("tsunami").getAsDouble();
        double sig = json.getAsJsonObject("properties").get("sig").getAsDouble();

        // geometry
        String geoType = json.getAsJsonObject("geometry").get("type").getAsString();
//        double[] coordinates = new double[]{json.getAsJsonObject("geometry").get("coordinates").getAsDouble()};

        return new Earthquake(id, place, time, magnitude, magType, type, status, geoType,
                title, types, code, sources, tsunami, sig);
    }

    static String dateTimeFormatter(Long instant) {

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(instant), ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        return formatter.format(zonedDateTime);

    }
}
