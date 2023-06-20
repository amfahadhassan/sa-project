package edu.miu.ripperService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "procssedearthquake")
public class ProcessedEarthquake {
    @Id
    private String id;
    private double magnitude;
    private String place;
    private String time;

    public ProcessedEarthquake(String id, String place, String time, double magnitude) {
        this.id = id;
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "{"
                + " \"id\":\"" + id + "\""
                + ", \"place\":\"" + place + "\""
                + ", \"time\":\"" + time + "\""
                + ", \"magnitude\":" + magnitude            // double field
                + "}";
    }
}
