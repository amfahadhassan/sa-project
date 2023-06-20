package sa.miu.RTDIS.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "earthquake")
public class Earthquake {
    @Id
    private String id;
    private String place;
    private String time;
    private double magnitude;
    private String magType;
    private String type;
    private String status;
    private String geoType;
    private double[] coordinates;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public double getTsunami() {
        return tsunami;
    }

    public void setTsunami(double tsunami) {
        this.tsunami = tsunami;
    }

    public double getSig() {
        return sig;
    }

    public void setSig(double sig) {
        this.sig = sig;
    }

    private String title;
    private String types;
    private String code;
    private String sources;

    private double tsunami;
    private double sig;

    public Earthquake(String id, String place, String time,
                      double magnitude, String magType, String type,
                      String status, String geoType /**, double[] coordinates**/
                    , String title, String types, String code, String sources,
                      double tsunami, double sig) {
        this.id = id;
        this.place = place;
        this.time = time;
        this.magnitude = magnitude;
        this.magType = magType;
        this.type = type;
        this.status = status;
        this.geoType = geoType;
//        this.coordinates = coordinates;
        this.title = title;
        this.types = types;
        this.code = code;
        this.sources = sources;
        this.tsunami = tsunami;
        this.sig = sig;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getMagType() {
        return magType;
    }

    public void setMagType(String magType) {
        this.magType = magType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGeoType() {
        return geoType;
    }

    public void setGeoType(String geoType) {
        this.geoType = geoType;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "{"
                + ", \"id\":\"" + id + "\""
                + ", \"place\":\"" + place + "\""
                + ", \"time\":\"" + time + "\""
                + ", \"magnitude\":" + magnitude            // double field
                + ", \"magType\":\"" + magType + "\""
                + ", \"type\":\"" + type + "\""
                + ", \"status\":\"" + status + "\""
                + ", \"geoType\":\"" + geoType + "\""
                + ", \"title\":\"" + title + "\""
                + ", \"types\":\"" + types + "\""
                + ", \"code\":\"" + code + "\""
                + ", \"sources\":\"" + sources + "\""
                + ", \"tsunami\":" + tsunami            // double field
                + ", \"sig\":" + sig                    // double field
                + "}";
    }
}
