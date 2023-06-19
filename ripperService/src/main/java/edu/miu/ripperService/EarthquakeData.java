package edu.miu.ripperService;

public class EarthquakeData {
	private double magnitude;
    private double latitude;
    private double longitude;
    private String location;
    
	public double getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(double magnitude) {
		this.magnitude = magnitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "EarthquakeData [magnitude=" + magnitude + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", location=" + location + "]";
	}
}
